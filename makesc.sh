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
    #echo "-b -   using scala sbt builder. Create a binary crate with filename given."
    echo "-c -   using scala sbt package builder. Compile, and run, then clean."
    #echo "-C -   change into the directory given as parameter; then cargo run and clean."
    echo "-d -   deleting the file specified."
    #echo "-e -   using scalac --explain [number]. it output scala explaination."
    echo "-g -   generating a single scala file, then run the file."
    echo "-h -   getting to display the help function."
    #echo "-l -   using scala cargo builder. Crate a library crate with filename given."
    echo "-p -   create other folders that might be needed in a structured scala poject."
    echo "-r -   run a scala file."
    #echo "-t     using scala cargo it run both unittest and integation test."
    #echo "-T     without the cargo, using scalac to run test on a scala file"
    echo "-s     save the file or project using gitter, which calls git."
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
    echo "
    package com.package."${file%.*}" 

    @main def main(args: Array[String]): Unit = 
    		println("Hello, World!")

    " > "${file}"
}


if [[ "$#" -ne 2 ]]; then
	help
fi

# optstring consist of
# scalac, cargo new <folder>
optstring="a:b:c:C:d:e:g:k:l:p:r:s:t:T:h"
while getopts "${optstring}" opt; do
    case "${opt}" in
        a)
            # directory to make github workflow into
            directory="${OPTARG,,}"

            make_github_action_workflow "${directory}"
        ;;
        r)
            filename="${OPTARG,,}"
            check_file_ext "${filename}"
            scalac "${filename}"
            file=$(basename "${filename%.*}")
            ./"${file}" # run the file
            rm "${file}"
        ;;
        s)
            filename="${OPTARG}"
            gitter "${filename}"
        ;;
        b)
        # create a binary crate
            filename="${OPTARG,,}"
            cargo new --bin "${filename}"
            [[ "${filename}" != "${PWD}" ]] && cd "${filename}"
            cargo check
            cargo clean
        ;;
        C)
            # change the directory to cargo run and build
            # clean up
            filename="${OPTARG}"
            [[ "${filename}" != "${PWD}" ]] && cd "${filename}"
            cargo run
            cargo clean
        ;;
        c)
        # using scala cargo to compile
            filename="${OPTARG,,}"
            file=$(basename "${filename%.*}")
            # check to see if the directory exists
            # if yes; ask to delete it
            # if no exit.
            if [[ -e "${file}" ]]; then
                while read -p "Do you want to delete ${file} directory? [y|n]: " ans; do
                    case "${ans,,}" in
                        y)
                            rm -rf "${file}"
                            echo "${file} deleted!"
                            exit 0
                        ;;
                        n)
                            echo "${file} not deleted."
                            # clean up the scala directory
                            # change into that directory
                            cd "${file}"
                            cargo clean  # clean up
                            exit 1
                        ;;
                    esac
                done
            fi
            cargo new "${file}"
            cd "${file}"
            cargo run
            cargo clean
        ;;
        d)
            file="${OPTARG}"
            files=
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
        e)
            explain_number="${OPTARG}"
            scalac --explain "E${explain_number}"
        ;;
        g)
        # create a scala file from the scratch and compile it
            filename="${OPTARG}"
            create_scala_file "${filename}"
            scalafmt "${filename}"
            "${0}" -r "${filename}"
        ;;
        k)
        ;;
        l)
        # create a library crate
            filename="${OPTARG,,}"
            cargo new --lib "${filename}"
            [[ "${filename}" != "${PWD}" ]] && cd "${filename}"
            cargo test
            cargo clean
        ;;
        p)
            # create other folders that would be needed
            # in a structured scala project
            directory="${OPTARG}"

            # call the create complete structured project
            # from start to finish
            ! [[ -e "${directory}" ]] && "${0}" -c "${directory}"

            mkdir "${directory}"/tests  2>/dev/null     # makes tests directory
            touch "${directory}"/tests/mod.rs           # make a mod.rs for the integerated test
            mkdir "${directory}"/src/bin    2>/dev/null # make the bin directory

            # check if main.rs exists in the src directory
            # if yes, move it to bin folder
            # if NOT, make a new main.rs file in the bin directory
            main_file="main.rs"
            if [[ -e ""${directory}"/src/${main_file}" ]]; then
                mv "${directory}"/src/"${main_file}" "${directory}"/src/bin/"${main_file}"   # move the main.rs into bin directory
            else
                touch "${directory}"/src/bin/"${main_file}"
                create_scala_file "${directory}"/src/bin/"${main_file}"
            fi;

            # check for lib.rs file
            lib_file="lib.rs"
            if ! [[ -e "${directory}"/src/"${lib_file}" ]]; then
                touch "${directory}"/src/"${lib_file}"
                echo "pub mod ${directory,,};" > "${directory}"/src/"${lib_file}"
            fi

            # check and create a project file and call unittest form their
            directory_file="${directory,,}.rs"
            unittest_file="unittest.rs"
            if ! [[ -e "${directory}"/src/"${directory_file}" ]]; then
                touch "${directory}"/src/"${directory_file}"

                echo "#[cfg(test)]" > "${directory}"/src/"${directory_file}"
                echo "mod unittest;" >> "${directory}"/src/"${directory_file}"
            fi
            if ! [[ -e "${directory}"/src/"${directory,,}" ]]; then
                mkdir "${directory}"/src/"${directory,,}"
                touch "${directory}"/src/"${directory,,}"/"${unittest_file}"
                echo "use super::*;" > "${directory}"/src/"${directory,,}"/"${unittest_file}"
            fi

            # make github directory
            make_github_action_workflow "$directory"
        ;;
        t)
          # test the library crate
          filename="${OPTARG,,}"
          [[ "${filename}" != "${PWD}" ]] && cd "${filename}"
          cargo test
          cargo clean
        ;;
        T)
            filename="${OPTARG,,}"
            test_binary="${filename%.*}_test"
            scalac --test "${filename}" -o "${test_binary}" && ./"${test_binary}"
            rm -rf "${test_binary}"
        ;;
        h)
            help
        ;;
        *)
        ;;
    esac
done
