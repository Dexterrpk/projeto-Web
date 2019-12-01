<%@page import="java.util.List"%>
<%@page import="entidades.pojo.Disciplina"%>
<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
       <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
        <title>Disciplina </title>
    </head>
    <body bgcolor="blue" align="center"  background="xx.jpg" > 
                    <font   style="background: blue" size="6"  >
    <script type="text/javascript">
            function confirmaExclusao(pk_disciplina) {

                if (window.confirm("Tem Certeza que Deseja Excluir? ")) {
                    location.href = "http://localhost:8080/ProvaWeb/DisciplinaServlets?acao=exc&id=" + pk_disciplina;
                }
            }


        </script>


        <%
            List<Disciplina> lista = (List<Disciplina>) request.getAttribute("lista");
        %> 

        <form width="200px" align="center">

            <table>
                <tr >

                    <th ><input type="button" value="Atualizar" onClick="history.go(0)"></th>
                    <th><input type="button" value="Voltar" onClick="history.go(-1)"></th>

                </tr>
            </table>

            <table  aling="left" border="9" >

                <tr>    <th> <center>Id Disciplina </center> </th> 
                <th> <center> Nome da Disciplina </center>  </th>
                <th> Carga Horária </th> <th> Id Proposta de Curso </th> 
                <th> Ação </th> 
                <th> Ação </th>

                </tr>

                <%for (Disciplina dis : lista) {%>
                <tr> 
                    <td> <%out.print(dis.getPk_disciplina());%>             <br>  </td>
                    <td> <%out.print(dis.getNome_disciplina());%>      <br>  </td>
                    <td> <%out.print(dis.getCarga_horaria());%>      <br>  </td>
                    <td> <%out.print(dis.getId__proposta_curso());%>  <br>  </td>
                    
                    <td> <a href="javascript:confirmaExclusao(<%=dis.getPk_disciplina()%>)"> Excluir</a>                      </td> 
                    <td> <a href="DisciplinaServlets?acao=alt&id=<%=dis.getPk_disciplina()%>"> Alterar </a>           </td>




                    <%}%>
            </table>
        </form>

</html>
