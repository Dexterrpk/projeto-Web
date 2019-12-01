
<%@page import="conexao.PropostadeCursoDAO"%>
<%@page import="entidades.pojo.PropostadeCurso"%>
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
        <title>Formulário Curso </title>
    </head>

    <body bgcolor="blue"  background="xx.jpg" >
        <font style="color: purple  ">
        <%
            PropostadeCurso pc = (PropostadeCurso) request.getAttribute("con");


        %>

        <form action="PropostadeCursoServlets" method="post" >

            <b>Id </b>
            <input  type="text" name="pk_proposta_curso" value="<%=pc.getPk_proposta_curso()%>" >

           <b> Nome do Curso </b>
            <input type="text" name="nome_curso" value="<%=pc.getNome_curso()%>">
            <br>
            <br>
            <br>
           <b> Descrição do Curso </b> <br>
            <textarea  rows="2" cols="65" name="descricao" > <%= pc.getDescricao()%> </textarea>

            <br>
            <br>
            <br>
            <b> Perfil de Perfil de Engresso </b><br>
            <textarea  rows="2" cols="65" name="perfilengresso" > <%= pc.getPerfilengresso()%> </textarea>
            <br>
            <br>

            <input type="submit"    value="Salvar" onclick="funcao1()" >

            <input type="button" value="Voltar" onClick="history.go(-1)"> 
            <input type="button" value="Limpar" onClick="history.go(0)">




            <script>
                function funcao1()
                {
                    alert("Concluido!");
                    alert("Click pra voltar para Página Inicial ");
                    
                }
            </script>

        </form>

</html>
