// Copyright 2017 Google Inc. All Rights Reserved.
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
// http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.


package com.google.api.ads.adwords.jaxws.v201702.cm;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CampaignPreferenceError.Reason.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="CampaignPreferenceError.Reason">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="PREFERENCE_ALREADY_EXISTS"/>
 *     &lt;enumeration value="PREFERENCE_NOT_FOUND"/>
 *     &lt;enumeration value="UNKNOWN"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "CampaignPreferenceError.Reason")
@XmlEnum
public enum CampaignPreferenceErrorReason {


    /**
     * 
     *                 A campaign cannot have two preferences with the same preference key.
     *               
     * 
     */
    PREFERENCE_ALREADY_EXISTS,

    /**
     * 
     *                 No preference matched the given preference key.
     *               
     * 
     */
    PREFERENCE_NOT_FOUND,
    UNKNOWN;

    public String value() {
        return name();
    }

    public static CampaignPreferenceErrorReason fromValue(String v) {
        return valueOf(v);
    }

}
