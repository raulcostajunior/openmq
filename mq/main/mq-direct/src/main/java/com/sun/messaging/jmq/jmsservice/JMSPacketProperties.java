/*
 * Copyright (c) 2000, 2017 Oracle and/or its affiliates. All rights reserved.
 * Copyright (c) 2021 Contributors to the Eclipse Foundation
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v. 2.0, which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * This Source Code may also be made available under the following Secondary
 * Licenses when the conditions for such availability set forth in the
 * Eclipse Public License v. 2.0 are satisfied: GNU General Public License,
 * version 2 with the GNU Classpath Exception, which is available at
 * https://www.gnu.org/software/classpath/license.html.
 *
 * SPDX-License-Identifier: EPL-2.0 OR GPL-2.0 WITH Classpath-exception-2.0
 */

package com.sun.messaging.jmq.jmsservice;

import java.util.Hashtable;
import java.util.Map;

/**
 * The JMSPacketProperties class encapsulates the properties as used by the MQ wire protocol.
 * <p>
 * All relevant properties that need to be passed can be correctly set using methods that follow the pattern
 * {@code set<PropertyName>}, where {@code <PropertyName>} is replaced with the name of the property in the MQ wire
 * protocol.<br>
 */
public class JMSPacketProperties extends Hashtable<String, Object> {

    private static final long serialVersionUID = -2770279263000523841L;
    public static final String JMQStatus = "JMQStatus";
    public static final String JMQErrorCode = "JMQErrorCode";

    /**
     * Creates a new instance of JMSPacketProperties
     */
    public JMSPacketProperties() {
    }

    public JMSPacketProperties(Map<? extends String, ? extends Object> map) {
        super(map);
    }

    /**
     * Sets the JMQUserAgent property for JMS-DIRECT mode clients
     *
     * @deprecated since 6.3, will be removed without replacement in future release
     */
    @Deprecated
    public void setJMQUserAgent() {
        String ua = "SJSMQ/4.1 JMS-DIRECT; " + System.getProperty("os.name") + " " + System.getProperty("os.version") + " " + System.getProperty("os.arch")
                + " )";
        super.put("JMQUserAgent", ua);
    }

    /**
     * Gets the JMQUserAgent property from this JMSService request parameter
     *
     * @deprecated since 6.3, will be removed without replacement in future release
     * @return The JMQUserAgent string
     */
    @Deprecated
    public String getJMQUserAgent() {
        return (String) super.get("JMQUserAgent");
    }

    /**
     * Sets the JMQConnectionID property for JMS-DIRECT clients
     *
     * @deprecated since 6.3, will be removed without replacement in future release
     */
    @Deprecated
    public void setJMQConnectionID(long connectionID) {
        super.put("JMQConnectionID", connectionID);
    }
}
