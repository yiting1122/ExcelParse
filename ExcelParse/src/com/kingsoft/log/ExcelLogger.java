/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.kingsoft.log;

import org.apache.log4j.*;

public class ExcelLogger extends Logger {

	private static ExcelLoggerFactory myFactory = new ExcelLoggerFactory();

	public ExcelLogger(String name) {
		super(name);
		PropertyConfigurator.configure (".\\log4j.properties");
	}
	
	public static Logger getLogger(String name) {
		return Logger.getLogger(name, myFactory);
	}

	
	public void debug(String className,Object message) {
		super.log(className, Level.DEBUG, message , null);
	}


	public void warn(String className,Object message) {
		super.log(className, Level.WARN, message , null);
	}
	
	public void error(String className,Object message) {
		super.log(className, Level.ERROR, message , null);
	}
	
	public void trace(String className,Object message) {
		super.log(className, Level.DEBUG, message, null);
	}
}
