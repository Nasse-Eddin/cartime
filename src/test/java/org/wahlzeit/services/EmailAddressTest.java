/*
 * Copyright (c) 2006-2009 by Dirk Riehle, http://dirkriehle.com
 *
 * This file is part of the Wahlzeit photo rating application.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public
 * License along with this program. If not, see
 * <http://www.gnu.org/licenses/>.
 */

package org.wahlzeit.services;

import junit.framework.TestCase;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import org.wahlzeit.services.mailing.EmailServiceManager;

/**
 * Test cases for the EmailAddress class.
 */
public class EmailAddressTest extends TestCase {


    /**
     *
     */
    public EmailAddressTest(String name) {
        super(name);
    }

    @Test
    public void testGetEmailAddressFromInvalidString() {
        EmailAddress.STRONG_CHECK = true;
        assertFalse(createEmailAddressIgnoreException("bingo+bongo@bango"));
        assertFalse(createEmailAddressIgnoreException("bingo@bongo"));
        assertFalse(createEmailAddressIgnoreException("bingo.bongo"));
        assertFalse(createEmailAddressIgnoreException(" "));
        assertFalse(createEmailAddressIgnoreException("15"));
        assertFalse(createEmailAddressIgnoreException("bin@bing@bin"));
        assertFalse(createEmailAddressIgnoreException("!bin@bing.bin"));
    }

    /**
     *
     */
    @Test
    public void testGetEmailAddressFromValidString() {
        // invalid email addresses are allowed for local testing and online avoided by Google
        assertTrue(createEmailAddressIgnoreException("bingo@bongo.com"));
        assertTrue(createEmailAddressIgnoreException("bingo.bongo@bongo.com"));
        EmailAddress.STRONG_CHECK = false;
    }


    /**
     *
     */
    protected boolean createEmailAddressIgnoreException(String ea) {
        try {
            EmailAddress.getFromString(ea);
            return true;
        } catch (IllegalArgumentException ex) {
            // creation failed
            return false;
        }
    }

    /**
     *
     */
    public void testEmptyEmailAddress() {
        assertFalse(EmailAddress.EMPTY.isValid());
        assertFalse(EmailAddress.doGetFromString("").isValid());
    }

}

