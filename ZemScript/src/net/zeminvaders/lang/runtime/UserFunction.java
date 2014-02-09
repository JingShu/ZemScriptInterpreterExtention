/*
 * Copyright (c) 2008 Cameron Zemek
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to
 * deal in the Software without restriction, including without limitation the
 * rights to use, copy, modify, merge, publish, distribute, sublicense, and/or
 * sell copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING
 * FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS
 * IN THE SOFTWARE.
 */
package net.zeminvaders.lang.runtime;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import net.zeminvaders.lang.Interpreter;
import net.zeminvaders.lang.SourcePosition;
import net.zeminvaders.lang.ast.FunctionNode;
import net.zeminvaders.lang.ast.Node;

/**
 * A user declared function.
 *
 * @author <a href="mailto:grom@zeminvaders.net">Cameron Zemek</a>
 */
public class UserFunction extends Function {
    private List<Parameter> parameters;
    private Node body;
    
    /* added by Jing Shu */
    Map<String, ZemObject> env;

    public UserFunction(List<Parameter> parameters, Node body, Map<String, ZemObject> env) {
        this.parameters = parameters;
        this.body = body;
        this.env = new HashMap<String, ZemObject>(env);
    }

    public Node getBody() {
        return body;
    }
    
    public Map<String, ZemObject> getEnv(){
    	return env;
    }
    
    public void setEnv(Map<String, ZemObject> env){
    	this.env = new HashMap<String, ZemObject>(env);
    }

    @Override
    public int getParameterCount() {
        return parameters.size();
    }

    @Override
    public String getParameterName(int index) {
        return parameters.get(index).getName();
    }

    @Override
    public ZemObject getDefaultValue(int index) {
        return parameters.get(index).getDefaultValue();
    }

    @Override
    public ZemObject eval(Interpreter interpreter, SourcePosition pos) {
        try {
        	Interpreter localInterpreter = new Interpreter();
        	Map<String, ZemObject> newEnv = new HashMap<String, ZemObject>(interpreter.getSymbolTable());
        	newEnv.putAll(env);
        	localInterpreter.setSymbolTable(newEnv);
        	
            return body.eval(localInterpreter);
        } catch (ReturnException e) {
            return e.getReturn();
        }
    }
}
