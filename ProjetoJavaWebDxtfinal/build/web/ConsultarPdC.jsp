

<%@page import="java.util.List"%>
<%@page import="entidades.pojo.PropostadeCurso"%>
<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
        <title>Consultar Proposta de Curso </title>
    </head>
<body bgcolor="blue" align="center"  background="xx.jpg" > 
                    <font   style="background: blue" size="6"  >
        <script type="text/javascript">
            function confirmaExclusao(pk_proposta_curso) {

                if (window.confirm("Tem Certeza que Deseja Excluir? ")) {
                    location.href = "http://localhost:8080/ProvaWeb/PropostadeCursoServlets?acao=exc&pk_proposta_curso=" + pk_proposta_curso;
                }
            }


        </script>


        <%
            List<PropostadeCurso> lista = (List<PropostadeCurso>) request.getAttribute("lista");
        %>

        <form width="200px" align="center">

            <table>
                <tr >

                    <th ><input type="button" value="Atualizar" onClick="history.go(0)"></th>
                    <th><input type="button" value="Voltar" onClick="history.go(-1)"></th>

                </tr>
            </table>

            <table border="9">

                <tr>    <th> <center>Id Proposta de Curso </center> </th> 
                <th> <center> Nome do Curso </center>  </th>
                <th> Descrição </th> <th> Perfil de Engresso </th> 
                <th> Ação </th> 
                <th> Ação </th>

                </tr>
                
                <%for (PropostadeCurso pro :lista) {%>
                <tr> 
                    <td> <%out.print(pro.getPk_proposta_curso());%>             <br>  </td>
                    <td> <%out.print(pro.getNome_curso());%>      <br>  </td>
                    <td> <%out.print(pro.getDescricao());%>      <br>  </td>
                    <td> <%out.print(pro.getPerfilengresso());%>      <br>  </td>
                    
                    <td> <a href="javascript:confirmaExclusao(<%=pro.getPk_proposta_curso()%>)"> Excluir</a>                      </td> 
                    <td> <a href="PropostadeCursoServlets?acao=alt&pk_proposta_curso=<%=pro.getPk_proposta_curso()%>"> Alterar </a>           </td>




                    <%}%>

               
            </table>
        </form>


    </body>
</html>
