<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="2.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

    <xsl:variable name="syncToken" select="contact/syncToken"/>
    <xsl:variable name="nextCommand" select="contact/nextCommand"/>

    <xsl:template match="/">
        <html>
            <head>
                <title>New person</title>
            </head>
            <body>
                <table id="list"
                       border="1">
                    <tr>
                        <th>First name</th>
                        <th>Last name</th>
                        <th>Middle name</th>
                        <th>Birth date</th>
                    </tr>
                    <xsl:for-each select="person">
                        <tr>
                            <th><xsl:value-of select="firstName"/></th>
                            <th><xsl:value-of select="lastName"/></th>
                            <th><xsl:value-of select="middleName"/></th>
                            <th><xsl:value-of select="birthDate"/></th>
                        </tr>
                    </xsl:for-each>
                </table>
                <form action="add.fc" method="post">
                    <input type="submit" value="add"/>
                </form>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>