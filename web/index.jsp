<%-- 
    Document   : index
    Created on : 20/09/2013, 20:39:00
    Author     : daves
--%>

<%@page contentType="text/html" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<jsp:useBean id="resposta" scope="request" class="java.lang.String" />
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
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
                        </div>  
                        <!-- end horizontal navigation -->  
                        <!--  content -->  
                        <div id="content"> 
                            <div id="center"> 
                                <div id="welcome"> 
                                    <h3>SASCrypto</h3>  
                                    <p>Aplicação Exemplo de criptografia.                      

                                    </p>  
                                    <div class="tabs">

                                        <div class="tab">
                                            <input type="radio" id="tab-1" name="tab-group-1" checked>
                                                <label for="tab-1">HASING</label>

                                                <div class="content">
                                                    <form action="adicionarContato" method="post">
                                                        <div>Nome: <input type="text" name="user" /></div>
                                                        <div>Senha: <input type="password" name="senha" /></div>
                                                        <div>
                                                            <select name="tipoHash">
                                                                <option id="MD2" value="MD2">MD2</option>
                                                                <option id="MD5" value="MD5">MD5</option>
                                                                <option id="SHA1" value="SHA1">SHA-1</option>
                                                                <option id="SHA256" value="SHA256">SHA-256</option>
                                                                <option id="SHA384" value="SHA384">SHA-384</option>
                                                                <option id="SHA512" value="SHA512">SHA-512</option>
                                                            </select>
                                                        </div>
                                                        <input type="submit" value="Gerar Hash" />
                                                    </form>
                                                    <div style="padding-top: 10px;">
                                                        <%if(!resposta.isEmpty()){%>
                                                        ${resposta}
                                                        <%}%>
                                                    </div>
                                                    <div style="padding-top: 10px;">
                                                        <a href="login.jsp">Fazer login</a>
                                                    </div>
                                                </div> 
                                        </div>

                                        <div class="tab">
                                            <input type="radio" id="tab-2" name="tab-group-1">
                                                <label for="tab-2">CRIPTOGRAFIA SIMÉTRICO</label>

                                                <div class="content">
                                                    CRIPTOGRAFIA SIMÉTRICO
                                                </div> 
                                        </div>

                                        <div class="tab">
                                            <input type="radio" id="tab-3" name="tab-group-1">
                                                <label for="tab-3">CRIPTOGRAFIA ASSIMÉTRICO</label>

                                                <div class="content">
                                                    CRIPTOGRAFIA ASSIMÉTRICO
                                                </div> 
                                        </div>
                                        <div class="tab">
                                            <input type="radio" id="tab-4" name="tab-group-1">
                                                <label for="tab-4">ASSINATURA DIGITAL</label>

                                                <div class="content">
                                                    ASSINATURA DIGITAL
                                                </div> 
                                        </div>

                                    </div>
                                    <p style="clear:both" /> 
                                </div> 
                            </div>  
                            <!--              <div id="right"> 
                                            <div id="sidebar"> 
                                              <h3>Categories</h3>  
                                              <ul class="vmenu">
                                                <li>
                                                  <a href="#" shape="rect">Category 1</a>
                                                </li>
                                                <li>
                                                  <a href="#" shape="rect">Category 2</a>
                                                </li>
                                                <li>
                                                  <a href="#" shape="rect">Category 3</a>
                                                </li>
                                                <li>
                                                  <a href="#" shape="rect">Category 4</a>
                                                </li>
                                                <li>
                                                  <a href="#" shape="rect">Category 5</a>
                                                </li>
                                              </ul>  
                                              <h3 style="margin-top:40px">News</h3>  
                                              <p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Sed non risus. Suspendisse lectus tortor, dignissim sit amet, adipiscing nec, ultricies sed, dolor. Cras elementum ultrices diam. Maecenas ligula massa, varius a, semper congue, euismod non, mi.</p>  
                                              <div style="font-weight:bold;margin-top:20px">Call us : 00-123-456-789</div>  
                                              <div style="text-align:center;margin:20px 0"> 
                                                <img src="images/fitness-2.jpg" /> 
                                              </div> 
                                            </div> 
                                          </div>  -->
                            <div class="clear" style="height:40px"></div> 
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

