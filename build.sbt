name := "instamap"

version := "0.1"

scalaVersion := "2.10.3"

resolvers += "spray repo" at "http://repo.spray.io"

val akkaV = "2.3.0"
val sprayV = "1.3.1"

libraryDependencies ++= Seq(
  "io.spray"            %   "spray-can"     % sprayV,
  "io.spray"            %   "spray-routing" % sprayV,
  "io.spray"            %   "spray-caching" % sprayV,
  "io.spray"			      %	  "spray-testkit" % sprayV,
  "io.spray"			      %	  "spray-io"      % sprayV,
  "com.typesafe.akka"   %%  "akka-actor"    % akkaV,
  "com.typesafe.akka"   %%  "akka-testkit"  % akkaV,
  "com.typesafe.akka"   %%  "akka-kernel"   % akkaV,
  "com.typesafe.akka"   %%  "akka-cluster"  % akkaV,
  "com.typesafe.akka"   %%  "akka-remote"   % akkaV,
  "com.typesafe.akka"   %%  "akka-slf4j"    % akkaV
)
