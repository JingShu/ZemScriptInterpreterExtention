ZemScriptInterpreterExtention
=============================

Developers : Abdoul Diallo <mrdiallo.abdoul@gmail.com> , Jing Shu <js.shujing@gmail.com>

Original code source : https://code.google.com/p/zemscript/


Steps to take in order to test our project in terminal : 

    1. Open your consol on the root folder of the project
    2. Type "ant" to build the project and you will have 2 jar files created : ZemScripCall.jar and ZemScripDS.jar
    3. Type "java -jar ZemScripDS.jar" to test the primitive "Set" and the control structure "switch", or type "java -jar ZemScripCall.jar" to test the control structure "call/cc"



Steps to take in order to test our project with Eclipse : 

  To test the primitive "Set" and the control structure "switch" : 

    1. open the file "sampleDS.zem", this is a mini script to interpret
    2. launch the java class "src.test.TestDS" that contains our main method
    3. check the output result
    
  To test the control structure "call/cc" :
  
    1. open the file "sampleCallCC.zem"
    2. launch the java class "src.test.TestCallCC" that contains our main method
    3. check the output result
