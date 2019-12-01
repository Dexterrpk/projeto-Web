
<%@page import="entidades.pojo.Bibliografia"%>
<%@page import="java.util.List"%>
<%@page import="entidades.pojo.Disciplina"%>
<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
       <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
        <title>Bibliografia </title>
    </head>
    <body bgcolor="blue" align="center"  background="xx.jpg" > 
                    <font   style="background: blue" size="6"  >
    <script type="text/javascript">
            function confirmaExclusao(pk_bibliografia) {

                if (window.confirm("Tem Certeza que Deseja Excluir? ")) {
                    location.href = "http://localhost:8080/ProvaWeb/BibliografiaServlets?acao=exc&pk_bibliografia=" + pk_bibliografia;
                }
            }


        </script>


        <%
            List<Bibliografia> lista = (List<Bibliografia>) request.getAttribute("lista");
        %> 

        <form width="200px" align="center">

            <table>
                <tr >

                    <th ><input type="button" value="Atualizar" onClick="history.go(0)"></th>
                    <th><input type="button" value="Voltar" onClick="history.go(-1)"></th>

                </tr>
            </table>

            <table  aling="left" border="9" >

                <tr>    <th> <center>Id Bibliografia </center> </th> 
                <th> <center> Descrição Bibliográfica </center>  </th>
                <th> Id da Disciplina </th> <th> Tipo da Bibliografia </th> 
                <th> Ação </th> 
                <th> Ação </th>

                </tr>

                <%for (Bibliografia bi : lista) {%>
                <tr> 
                    <td> <%out.print(bi.getPk_bibliografia());%>             <br>  </td>
                    <td> <%out.print(bi.getDescricao_bibliografica());%>      <br>  </td>
                    <td> <%out.print(bi.getId_disciplina());%>      <br>  </td>
                    <td> <%out.print(bi.getTipo_bibliografica());%>  <br>  </td>
                    
                    <td> <a href="javascript:confirmaExclusao(<%=bi.getPk_bibliografia()%>)"> Excluir</a>                      </td> 
                    <td> <a href="BibliografiaServlets?acao=alt&pk_bibliografia=<%=bi.getPk_bibliografia()%>"> Alterar </a>           </td>




                    <%}%>
            </table>
        </form>

</html>
