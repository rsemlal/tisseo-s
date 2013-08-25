import sbtassembly.Plugin._

import AssemblyKeys._

organization := "net.rsemlal"

name := "tisseo-s"

version := "1.0"

scalaVersion := "2.10.0"

scalacOptions += "-deprecation"

scalacOptions += "-feature"

scalacOptions += "-unchecked"

EclipseKeys.createSrc := EclipseCreateSrc.Default + EclipseCreateSrc.Resource

EclipseKeys.withSource := true

jarName in assembly := "secret-disc.jar"

seq(assemblySettings: _*)