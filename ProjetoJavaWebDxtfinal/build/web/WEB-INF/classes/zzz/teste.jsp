

<%@page import="entidades.pojo.Disciplina"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
           List<Disciplina> lista = (List<Disciplina>) request.getAttribute("lista"); 
        
        %>
             <%for (Disciplina dis : lista) {%>
                <tr> 
                    <td> <%out.print(dis.getPk_disciplina());%> 
                        <td> <%out.print(dis.getId__proposta_curso());%>  <br>  </td>
                        <%}%>
            
        <h1>Hello World!</h1>
    </body>
</html>
