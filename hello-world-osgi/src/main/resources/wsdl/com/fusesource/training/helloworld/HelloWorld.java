package com.fusesource.training.helloworld;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;

/**
 * This class was generated by Progress FUSE Services Framework 2.2.9-fuse-01-00
 * Wed Aug 25 15:08:13 EDT 2010
 * Generated source version: 2.2.9-fuse-01-00
 * 
 */
 
@WebService(targetNamespace = "http://fusesource.com/training/HelloWorld", name = "HelloWorld")
@XmlSeeAlso({ObjectFactory.class})
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
public interface HelloWorld {

    @WebResult(name = "sayHelloResponse", targetNamespace = "http://fusesource.com/training/HelloWorld", partName = "return")
    @WebMethod
    public java.lang.String sayHello(
        @WebParam(partName = "message", name = "message", targetNamespace = "http://fusesource.com/training/HelloWorld")
        java.lang.String message
    );
}