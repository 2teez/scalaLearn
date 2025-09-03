# Concrete 8-week Scala hire plan
## Week 1-2  | Scala boot-camp
  + “Scala for the Impatient” (chapters 1-12)
  + Exercism Scala track (finish 20 exercises)
  + Build a tiny Spark job on your laptop (word-count on 1 GB CSV).
## Week 3-4  | Spark certification
  + Databricks Spark Certified Associate (free vouchers via Databricks Academy).
  + Upload GitHub repo with:
    – Spark job + unit tests + sbt assembly build.
    – README.md with runtime & memory metrics.
## Week 5-6  | Project polish
  + Add Akka HTTP micro-service that exposes the Spark job via REST.
  + Docker-compose the whole stack (Scala + Spark + Postgres).
  + Deploy to Fly.io or Heroku (free tier) → live demo link.
## Week 7-8  | Apply & interview
  + Target 60 live Scala roles (Indeed filter: “Scala” + “Junior” + “UK”):


```txt
Below is the minimal book list that covers exactly what you need to land a Scala job in 4–8 weeks, plus a tight study plan that you can compress to 4 weeks if you sprint.
```

## Essential books

| Title	 |-- Pages	--| What it gives you|
|:-----|:-----:|:----------------:|
|Programming in Scala, 5th ed.	| 675	|Core language + Scala 3 constructs; mandatory for interviews.|
|Scala for the Impatient, 3rd ed.	| 400	|Fast-track Java/Scala bridge; complete in week 1.|
|Functional Programming in Scala, 2nd ed.	| 320	|FP + exercises → “red book” labs required for Spark/Akka roles.|
|Spark: The Definitive Guide (Databricks)	| 600	|Spark SQL & DataFrame API; skip RDD chapters.|
|Scala Cookbook, 2nd ed.	| 700	|Quick reference for interview Q&A; skim only.|

## Ultra-condensed 4-week sprint (8-week plan in brackets)
```css
    Week 1 – Language in 7 days
    ----------------------------
  -+ Day 1–3: Scala for the Impatient ch. 1-12 (collections, traits, case classes).

  -+ Day 4–5: Programming in Scala ch. 1-8 (pattern matching, implicits).

  -+ Day 6–7: Scala Cookbook snippets (common interview idioms).

    Week 2 – Functional core + exercises
    -------------------------------------
  -+ Day 8–10: FP in Scala ch. 1-5 exercises (Option, List, fold).

  -+ Day 11–12: Finish FP book exercises; push solutions to GitHub.

  -+ Day 13–14: Write micro-project: Scala CLI word-count using scala-cli.

    Week 3 – Spark + SBT
    --------------------
  -+ Day 15–16: Spark Definitive Guide ch. 1-6 (DataFrame basics).

  -+ Day 17–18: Build mini Spark job (CSV → Parquet) with SBT assembly.

  -+ Day 19–21: Add Akka HTTP micro-service exposing the Spark job.

   Week 4 – Polish & portfolio
   ---------------------------
  -+ Day 22–23: Dockerise the job; push to GitHub + live demo on Fly.io.

  -+ Day 24–26: Mock interviews (LeetCode Scala, FP questions).

  -+ Day 27–28: Apply to 15 targeted Scala roles with repo link in CV.
```

## 8-week fallback (if you prefer relaxed pace)
```css
  - +Weeks 1–2 = same as 4-week sprint Week 1–2.
  - +Weeks 3–4 = Spark Definitive Guide full read + Databricks Spark Associate exam.
  - +Weeks 5–6 = Akka HTTP micro-service + Akka Actor quick start.
  - +Weeks 7–8 = Polish + system-design mock + targeted applications.
```


| Company	| Role	             | Salary	  | Notes         |
|:---------:|:--------------------:|:----------:|:---------------:|
|Barclays	|Scala Data Engineer	 |£55-70 k	 | London, hybrid 2 days|
|Lloyds Banking Group	|Scala Developer	|£50-65 k	|Leeds or Manchester|
|Sky Betting & Gaming	|Scala Backend Engineer	|£55 k	|Leeds, remote 3 days|
|Thoughtworks	Graduate |Scala Consultant	|£45 k	|Remote-first
|Starling Bank	|Scala Engineer	|£60 k	|London or Edinburgh

```md
Interview ammo:
“I ported a Java micro-service to Scala + Spark, cut runtime 40 %, have live demo.”
Show GitHub repo with miri-clean Rust crates → proves you write safe, tested code in any JVM language.
```

#### Bottom line
        You’ll walk into Scala interviews in 8 weeks with Java/Kotlin credibility + Spark/Akka proof-of-skill—no crypto learning curve required.
