<%-- 
    Document   : login
    Created on : 04/10/2013, 14:53:43
    Author     : heitor.filho
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="resposta" scope="request" class="java.lang.String" />
<!DOCTYPE html>
<html>
    <head>
        <title>SASCrypto</title>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <meta name="title" content="SASCrypto" />
        <meta name="description" content="Site description here" />
        <meta name="keywords" content="SASCrypto, Criptografia" />
        <meta name="language" content="br" />
        <meta name="subject" content="daves martins" />
        <meta name="robots" content="All" />
        <meta name="copyright" content="CESJF" />
        <meta name="abstract" content="Site description here" />
        <meta name="MSSmartTagsPreventParsing" content="true" />
        <link id="theme" rel="stylesheet" type="text/css" href="style.css" title="theme" />
        <script type="text/javascript" src="js/jquery-1.10.2.min.js" ></script>
    </head>
    <body>
        <div id="wrapper"> 
            <div id="bg"> 
                <div id="header"></div>  
                <div id="page"> 
                    <div id="container"> 
                        <!-- horizontal navigation -->  
                        <div id="nav1"> 
                            <ul>
                                <li id="current" style="border:none">
                                    <a href="index.jsp" shape="rect">Home</a>
                                </li>
                            </ul> 
                            <br/>
                            <br/>
                            <br/>
                            <br/>
                            <div>
                                <h1>Fazer login</h1>
                                <form action="autenticar" method="POST">
                                    <div>Usuário: <input type="text" name="nomeUsuario" value="" /></div>
                                    <div>Senha: &nbsp;&nbsp;<input type="password" name="senha" value="" /></div>
                                    <div>
                                        Hash:  &nbsp;&nbsp;&nbsp;
                                        <select name="tipoHash">
                                            <option id="MD2" value="MD2">MD2</option>
                                            <option id="MD5" value="MD5">MD5</option>
                                            <option id="SHA1" value="SHA1">SHA-1</option>
                                            <option id="SHA256" value="SHA256">SHA-256</option>
                                            <option id="SHA384" value="SHA384">SHA-384</option>
                                            <option id="SHA512" value="SHA512">SHA-512</option>
                                        </select>
                                    </div>
                                    <div><input type="submit" value="Logar" name="logar" /></div>
                                </form>

                                <div>
                                    ${resposta}
                                </div>
                            </div>
                        </div>  
                        <!-- end horizontal navigation -->  
                        <!--  content -->  
                        <div id="content"> 
                            <div id="center"> 
                                <div id="welcome"> 
                                    <h3>SASCrypto</h3>  
                                    <p>Aplicação Exemplo de criptografia.                      

                                    </p>  


                                </div>  
                                <!-- end content --> 
                            </div>  
                            <!-- end container --> 
                        </div>  
                        <div id="footerWrapper"> 
                            <div id="footer"> 
                                <p style="padding-top:10px"> 
                                    Site SASCrypto - Disicplina Segurança e Auditoria de Sistema.
                                </p> 
                            </div> 
                        </div> 
                    </div> 
                </div> 
                </body>
                </html>
