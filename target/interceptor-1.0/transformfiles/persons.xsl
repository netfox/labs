<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="2.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

    <xsl:variable name="path" select="root/path"/>
    <xsl:variable name="current_page" select="root/currentPage"/>
    <xsl:variable name="numOfPages" select="root/numOfPages"/>

    <xsl:template match="/">
        <html>
            <body>
                <h2>Persons</h2>
                <xsl:apply-templates/>
                <xsl:if test="$current_page &gt; 1">
                    <form action="{$path}" method="post">
                        <input type="hidden" name="current_page" value="1"/>
                        <input type="hidden" name="command" value="currentPage"/>
                        <input type="submit" value="First page"/>
                    </form>
                </xsl:if>
                <xsl:if test="$current_page &gt; 1">
                    <form action="{$path}" method="post">
                        <input type="hidden" name="current_page" value="{$current_page}"/>
                        <input type="hidden" name="command" value="previousPage"/>
                        <input type="submit" value="Previous"/>
                    </form>
                </xsl:if>
                <xsl:if test="$current_page &lt; $numOfPages">
                    <form action="{$path}" method="post">
                        <input type="hidden" name="current_page" value="{$current_page}"/>
                        <input type="hidden" name="command" value="nextPage"/>
                        <input type="submit" value="Next"/>
                    </form>
                </xsl:if>
                <xsl:if test="$current_page &lt; $numOfPages">
                    <form action="{$path}" method="post">
                        <input type="hidden" name="current_page" value="{$numOfPages}"/>
                        <input type="hidden" name="command" value="currentPage"/>
                        <input type="submit" value="Last page"/>
                    </form>
                </xsl:if>
            </body>
        </html>
    </xsl:template>

    <xsl:template match="persons">
        <table id="list"
               border="1">
            <tr>
                <th>Name</th>
                <th>Birth date</th>
            </tr>
            <xsl:for-each select="person">
                <tr>
                    <th><xsl:apply-templates select="firstName | lastName"/></th>
                    <th><xsl:apply-templates select="birthDate"/></th>
                </tr>
            </xsl:for-each>
        </table>
    </xsl:template>

    <xsl:template match="firstName">
        <span style="color:#FF0000">
            <xsl:value-of select="."/>
        </span>

    </xsl:template>
    <xsl:template match="lastName">
        <span style="color:#0000FF">
            <xsl:value-of select="."/>
        </span>
    </xsl:template>
    <xsl:template match="birthDate">
        <span style="color:#00FF00">
            <xsl:value-of select="."/>
        </span>
    </xsl:template>

    <xsl:template match="currentPage">
    </xsl:template>

    <xsl:template match="numOfPages">
    </xsl:template>

    <xsl:template match="path">
    </xsl:template>
</xsl:stylesheet>