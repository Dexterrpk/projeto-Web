
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
        <title>Formulario Disciplina </title>
    </head>

    <body bgcolor="#00BFFF"  background="xx.jpg" >
        <font style="color: purple; background: black">
        <form action="DisciplinaServlets" method="post" >
            <%
                Disciplina des = (Disciplina) request.getAttribute("con");
            %>
            <table border="6" align="right"  style=" background: white; color: black">

                <td><b>Nome do Curso </b></td> <td><b>Id do Curso </b></td> </tr>   v
                <%
                    PropostadeCursoDAO dao = new PropostadeCursoDAO();
                    List<PropostadeCurso> lista = dao.consultarTodos();

                    for (PropostadeCurso pro : lista) {
                %>

                <tr> 

                    <td> <%out.print(pro.getNome_curso());%>      <br>  </td>

                    <td> <%out.print(pro.getPk_proposta_curso());%>  <br>  </td>                


                    <%}%>

            </table>


          <b>  Id Disciplina </b>
            <input  type="text" name="id" value="<%=des.getPk_disciplina()%>" >

          <b>  Nome da Disciplina</b>
            <input type="text" name="nome_disciplina" value="<%=des.getNome_disciplina()%>">
            <br>
            <br>
            <br>
           <b> Carga Horária </b><br>

            <input type="text" name="carga_horaria" value="<%= des.getCarga_horaria()%>">
            <br>
            <br>
            <br>
            <br>
            <br>
            <b>  Informe  Id Do Curso </b>
            <br>
            <br>
            <input type="text" name="id__proposta_curso" value="<%=des.getId__proposta_curso()%>">
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
                    alert("Sucesso !");
                    alert(" Redirecionando para Página Inicial ");
                }
            </script>

        </form>
</html>
