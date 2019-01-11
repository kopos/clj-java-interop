# About
This is a proof-of-concept Clojure application to explore the capabilities of interop between Clojure and Java.

# Objectives
- The `rgs` clojure app is deployed as a web application
- The `rgs` app's set of functions will be composed of multiple subsets of functions
- Each subset of functions will be served by a separate clojure namespace or a Java package 
- Closed source vendor modules (in Java, packaged as jars) should also be able to serve the subset of functions of the rgs app
- There will be a common set of functionality which is needed by both the clojure nses, java package and external jars which needs to be provided by the `rgs` app

# Module Layout
There are 3 modules / packages in total
- rgs.core
- rgs
- vendor

## rgs.core
These are a set of library functions which are used by both the vendor and rgs itself. Ideally the rgs and rgs.core is a closed source system and the source is not open to any of the vendors

## rgs
The overarching deployment artifact which has its own set of modules as well as needs to load the vendor jar

## vendor
This is a vendor managed closed source system which depends on `rgs` but also needed by `rgs` to provide functionality. This is supplied as a jar to rgs deployment

# Steps
* Compile rgs.core as a uberjar so that the rgs library functionality is shared with vendor
```bash
$ cd rgs/core
$ lein uberjar
$ cd -
```
* Compile rgs as a uberjar so that the rgs functionality is available
```bash
$ cd rgs
$ lein uberjar
$ cd -
```
* Build the vendor jar file which needs to be deployed on the rgs
```bash
$ cd vendor
$ make
$ cd -
```
* Test the vendor.jar build
```bash
$ java -cp target/rgs-0.1.0-standalone.jar:../vendor/vendor.jar Game
```
* Test the rgs app
```bash
$ java -cp target/rgs-0.1.0-standalone.jar Platform
```
