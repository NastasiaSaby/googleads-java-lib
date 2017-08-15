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


package com.google.api.ads.dfp.jaxws.v201708;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 *             Performs actions on {@link Team} objects that match the given {@link Statement#query}.
 *             
 *             @param teamAction the action to perform
 *             @param filterStatement a Publisher Query Language statement used to filter a set of teams
 *             @return the result of the action performed
 *           
 * 
 * <p>Java class for performTeamAction element declaration.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;element name="performTeamAction">
 *   &lt;complexType>
 *     &lt;complexContent>
 *       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *         &lt;sequence>
 *           &lt;element name="teamAction" type="{https://www.google.com/apis/ads/publisher/v201708}TeamAction" minOccurs="0"/>
 *           &lt;element name="filterStatement" type="{https://www.google.com/apis/ads/publisher/v201708}Statement" minOccurs="0"/>
 *         &lt;/sequence>
 *       &lt;/restriction>
 *     &lt;/complexContent>
 *   &lt;/complexType>
 * &lt;/element>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "teamAction",
    "filterStatement"
})
@XmlRootElement(name = "performTeamAction")
public class TeamServiceInterfaceperformTeamAction {

    protected TeamAction teamAction;
    protected Statement filterStatement;

    /**
     * Gets the value of the teamAction property.
     * 
     * @return
     *     possible object is
     *     {@link TeamAction }
     *     
     */
    public TeamAction getTeamAction() {
        return teamAction;
    }

    /**
     * Sets the value of the teamAction property.
     * 
     * @param value
     *     allowed object is
     *     {@link TeamAction }
     *     
     */
    public void setTeamAction(TeamAction value) {
        this.teamAction = value;
    }

    /**
     * Gets the value of the filterStatement property.
     * 
     * @return
     *     possible object is
     *     {@link Statement }
     *     
     */
    public Statement getFilterStatement() {
        return filterStatement;
    }

    /**
     * Sets the value of the filterStatement property.
     * 
     * @param value
     *     allowed object is
     *     {@link Statement }
     *     
     */
    public void setFilterStatement(Statement value) {
        this.filterStatement = value;
    }

}
