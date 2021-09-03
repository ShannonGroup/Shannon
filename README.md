# SHANNON

## Introduction

Shannon is bounded model checking tool to verify scenario-controlled hybrid automata network (SHAN) model. Some model samples are given in the path `/cases/SHANNON`, and these models are constructed by [UMLet](https://www.umlet.com/).

## Dependency

### Java

- With version (>= 11)

### Z3

- Download prebuild binary from [Z3 repository](https://github.com/Z3Prover/z3/releases), version 4.8.7
- Copy binary to java home according to your OS

### Maven

- With version (>=3.6.0)

## Build Shannon

1. Clone code.
2. Install Z3 Java API to local maven repository by running the following command, where the Z3 jar file is included in the Z3 prebuild binaries.

```bash
mvn install:install-file -Dfile=<full-path-to-z3-jar-file> -DgroupId=com.microsoft.z3 -DartifactId=z3 -Dversion=4.8.7 -Dpackaging=jar -DgeneratePom=true 
```

3. Change the line 104 in the `pom.xml` in Shannon project to your local maven repository, such as `file:///Users/john/.m2/repository`.
4. Build the project by running the following command:

```bash
mvn install
```

5. Copy the files `libz3.a`, `libz3.dylib`, `libz3java.dylib`, `Microsoft.Z3.deps.json`, `Microsoft.Z3.dll`, and `z3` in the prebuild binaries to Shannon project directory.

## Configure the protocol 

- Configure the protocol which controls the experiment, and the protocol template is given in `/cases/protocol.json`
- Users need to change the `"base_path"` in the protocol to the full path of SHAN models, such as `/Users/John/Downloads/Shannon/cases/SHANNON`.

## Run the samples

After configuring the protocol, run the following command:

```bash
java -jar ./target/Shannon-1.0-SNAPSHOT.jar ${the full path of the protocol file}
```

