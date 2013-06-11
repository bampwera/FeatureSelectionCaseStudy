<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:output method="xml" version="1.0" indent="yes"/>
	
	<xsl:key name="the_url" match="meta" use="@property" />
	
	
	<xsl:template match="/"> 
		<authors>
			<xsl:for-each select="//aff">
				<locations>
					<xsl:attribute name="ref">
						<xsl:value-of select="./@id"/>
					</xsl:attribute>
					<xsl:value-of select="."/>
				</locations>			
			</xsl:for-each>
			<xsl:for-each select="//contrib/name">
				<author>
					<xsl:attribute name="aff">
						<xsl:value-of select="../xref/@rid"/>
					</xsl:attribute>
					<xsl:variable name="surname" select="./surname"/>
					<xsl:variable name="others" select="./given-names"/>
					<xsl:value-of select=" normalize-space(concat($surname,concat(' ',$others)))"/>
				</author>			
			</xsl:for-each>
		</authors>
	</xsl:template>
	
	<xsl:template match="authors">
		<xsl:element name="author">
			<xsl:value-of select="./surname"/>
		</xsl:element>
		
		
	</xsl:template>
	
</xsl:stylesheet>