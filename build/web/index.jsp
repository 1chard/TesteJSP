<%@page contentType="text/html" import="richard.ListaDinamica,
        java.nio.file.Path, java.nio.file.Files, java.nio.file.Paths,
        java.nio.file.DirectoryStream" %>

<html>
    <head>
        <style>
            * {
                padding: 0;
                margin: 0;
                box-sizing: border-box;
            }

            body{
                display: flex;
                flex-direction: row;
                height: 100vh;
                width: 100vw;
                justify-content: space-around;
                align-items: center;
            }
            
            main{
                border: 1px solid black;
                display: flex;
                gap: 10px;
                padding: 10px;
                flex-direction: column;
            }
            
            form{
                border: 1px solid black;
                display: flex;
                gap: 10px;
                padding: 10px;
                flex-direction: column;
            }

            ul{
                display: block;
                background-color: pink;
                
                
            }
            
            li::before{
                content: ">";
            }
            
            li{
                display: block;
                background-color: azure;
            }
            
            ul ul{
                padding-left: 30px;
            }
        </style>
    </head>
    <body>
        <main>
            
            <h1>As coisas serao mostradas aqui</h1>
        <%
            Path raiz = null;
            
            try{
          
                
                raiz = Paths.get(request.getParameter("diretorio"));
            
                DirectoryStream<Path> subarquivos = Files.newDirectoryStream(raiz);
                
                out.print("<ul>");
                
                for(Path arquivos : subarquivos){
                    out.print("<li>" + arquivos.getParent() + "</li>");
                }
                
                out.print("</ul>");
                
            }
            catch(Exception e){
                out.println(e.toString());
            }
            finally{
            
            }
            
               
        %>
        </main>

        <form method="post" action="">
            <div>
                <label>endereço no sistema (ex: "/home/tomcat/Arquivos")</label>
                <input type="text" name="diretorio">
            </div>
            <div>
                <input type="submit">
            </div>
        </form>
    </body>
</html>