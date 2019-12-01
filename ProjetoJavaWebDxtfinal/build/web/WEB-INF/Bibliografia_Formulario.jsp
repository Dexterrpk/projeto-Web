

<%@page import="entidades.pojo.Bibliografia"%>
<%@page import="entidades.pojo.PropostadeCurso"%>
<%@page import="conexao.PropostadeCursoDAO"%>
<%@page import="conexao.DisciplinaDAO"%>
<%@page import="java.util.List"%>
<%@page import="entidades.pojo.Disciplina"%>
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
        <title>Formulario Bibliografia </title>
    </head>

    <body bgcolor="blue"  background="xx.jpg" >
        <font style="color: purple; background: black">
        <form action="BibliografiaServlets" method="post" >
            <%
                Bibliografia bi = (Bibliografia) request.getAttribute("con");
            %>
            <table border="6" align="right"  style=" background: white; color: black">
                <tr><td style="align-content: flex-end">    <B>  Lista</b> </td></tr>  

                <td><b>Nome da Disciplina</b> </td> <td><b>Id Disciplina</b> </td> </tr>   
                <%
                    DisciplinaDAO dao = new DisciplinaDAO();
                    List<Disciplina> lista = dao.consultarTodos();

                    for (Disciplina dis : lista) {
                %>

                <tr> 

                    <td> <%out.print(dis.getNome_disciplina());%>      <br>  </td>

                    <td> <%out.print(dis.getPk_disciplina());%>  <br>  </td>                


                    <%}%>

            </table>
                    

            <b>  Id Bibliografia </b>
            <input  type="text" name="pk_bibliografia" value="<%=bi.getPk_bibliografia()%>" >

            <b>  Descrição Bibliográfica</b>
            <input type="text" name="descricao_bibliografia" value="<%=bi.getDescricao_bibliografica()%>">
            <br>
            <br>
            <br>
            <b> Tipo da Bibliografia </b><br>

            <input type="text" name="tipo_bibliografia" value="<%=bi.getTipo_bibliografica()%>">
            <br>
            <br>
            <br>
            <br>
            <br>
             <b> Id da Disciplina</b>
            <br>
            <br>
            <input type="text" name="id_disciplina" value="<%=bi.getId_disciplina()%>"
            <br>
            <br>
            <br>
            <br>
            <input type="button" value="Voltar" onClick="history.go(-1)"> 
            <input type="button" value="Limpar" onClick="history.go(0)">

            <input type="submit"  value="Salvar"  onclick="funcao1()">


            <script>
                function funcao1()
                {
                    alert("Concluiu com êxito !");
                    alert(" Redirecionando para Página Inicial ");
                }
            </script>

        </form>
</html>
