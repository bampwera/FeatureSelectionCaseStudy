AUTHORS
Brian AMPWERA
Sandra PIETROWSKA

Source code for Data Preparation Case Study

Includes
Tests for each methods developed
Running Example for Alogrithms 
	- Input Lastname of Author
	- Output Profiles of Authors Split according to Criteria Described in the Papers
Methods for Creating Ground Truh
   RequestDoi.java contains methods to connect to dx.doi.org and get True Author Name 
	-Requires work to do with XSLT Transformation
MainMethod
    Demostrates Visualisation of Connected Components



Dependencies
	Hibernate.cfg to connect to database
	PartialDump of database to Save Transportation Size
	Some modification made to orginal database available in attached dump
	Prefuse graphlibrary for visualisation 
	JUNG 2.0 For componenet Extration
	JSOUP for HTML scrapping and building of Group Truth
	Apacahe.Lucene for Computing JaroWinkler Disance
	Eclipse JUno SR1 Java 1.7

LICENSE


    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>.