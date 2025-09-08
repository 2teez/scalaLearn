#!/usr/bin/env bash
# Purpose: bash Cli command for scala programming language
# Author: omitida
# Date: 08/09/2025
#

# function to display help
function help() {
    file="${0}"
    echo "Usage: ${file} <option> <filename>"
    echo "Avaliable Options:"
    echo "-a -   create github action workflow into the specified directory."
    echo "-b -   using scalac. Create a binary jvm code using scala"
    echo "-d -   deleting the file specified."
    echo "-g -   generating a single standalone scala file, then run the file."
    echo "-h -   getting to display the help function."
    echo "-p -   create other folders that might be needed in a structured scala poject."
    echo "-r -   run a scala file."
    echo "-s     save the file or project using gitter, which calls git."
    echo "-S    script run of scala standalone file, using scala."
    echo
    exit 1
}

# global filename
filename=

#function to make github action workflow
function make_github_action_workflow() {
    dir="${1}"
    github_directory="${dir}"/.github
    if ! [[ -e "${github_directory}" ]]; then
        workflow_dir="${github_directory}"/workflows
        mkdir -p "${workflow_dir}"
        touch "${workflow_dir}"/main.yaml
    fi
}

# function to check the extension of a file
# and use a proper file extension
function check_file_ext() {
    file="${1,,}"

    ext="${file##*.}"
    file="${file%.*}"

    if [[ "${file}" == "${ext,,}" ]] || [[ "${ext,,}" != 'scala' ]]; then
        filename="${file}.scala"
    fi
}

function create_scala_file() {
    file="${1,,}"
    [[ -e "${file}" ]] && file="${file%.*}_.scala"
    file="${file%.*}.scala"
    file_without_ext="${file%.*}"
    echo "
    package com.progscala3.${file%.*}

    @main def ${file_without_ext^}(args: String*): Unit =
    		println(\"Hello, World!\")

    " > "${file^}"
}


if [[ "$#" -ne 2 ]]; then
	help
fi

# optstring consist of
# scalac, cargo new <folder>
optstring="a:d:g:r:s:S:h"
while getopts "${optstring}" opt; do
    case "${opt}" in
        a)
            # directory to make github workflow into
            directory="${OPTARG,,}"

            make_github_action_workflow "${directory}"
        ;;
        d)
            file="${OPTARG}"

            for my_file in $(ls | grep -i "${file}"); do
                while read -p "Do you want to delete ${my_file} [y|n]?: " ans; do
                    case "${ans,,}" in
                        y)
                            rm -rf "${my_file}"
                            echo "${my_file} deleted!"
                            break
                            ;;
                        n)
                            echo "${my_file} not deleted!"
                            break
                        ;;
                    esac
                done
            done
        ;;
        g)
        # create a scala file from the scratch and compile it
            filename="${OPTARG}"
            create_scala_file "${filename}"
            scalafmt "${filename}" 2>/dev/null
            "${0}" -r "${filename}"
        ;;
        r)
            # running a standalone scala file
            filename="${OPTARG,,}"
            check_file_ext "${filename}"
            scala "${filename}" 2>/dev/null
        ;;
        s)
            filename="${OPTARG}"
            gitter "${filename}"
        ;;
        S)
            # call two options on a standalone scala file
            file="${OPTARG}"
            script_name="${0}"
            "${script_name}" -g "${file}" #2>/dev/null
            ;;
        h)
            help
        ;;
        *)
        ;;
    esac
done
