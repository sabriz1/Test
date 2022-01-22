<%@page import="beans.Section"%>
<%@page import="service.SectionService"%>
<footer class="footer pt-3  ">
	<div class="container-fluid">

		<link href="include1/style.css" rel="stylesheet" type="text/css" />
		<link href="include1/csslocal.css" rel="stylesheet" type="text/css" />

		<form action="SectionController" method="GET">
			<input type="hidden" name="id"
				value="<%=request.getParameter("id") == null ? "" : request.getParameter("id")%>" />
			<%@page import="service.PlaceService"%>
			<%@page import="beans.Place"%>

			<fieldset style="width: 588px;">
				<legend>Section</legend>
				<table border="0">
					<tr>
						<td>code</td>
						<td><input id="code" type="text" name="code"
							value="<%=request.getParameter("code") == null ? "" : request.getParameter("code")%>"
							required="" style="width: 135px;" /></td>
						<td style="width: 307px;">*</td>
					</tr>

					<tr>
						<td style="width: 76px;">type</td>
						<td style="width: 737px;">
							<form action="some.jsp">
								<input id="type" type="text" name="type"
									value="<%=request.getParameter("type") == null ? "" : request.getParameter("type")%>"
									required="" style="width: 134px; height: 33px;" />
						</td>
					<tr>
						<td>prixParHeure</td>
						<td><input id="prixParHeure" type="text" name="prixParHeure"
							value="<%=request.getParameter("prixParHeure") == null ? "" : request.getParameter("prixParHeure")%>"
							required="" style="width: 135px;" /></td>
						<td style="width: 307px;">*</td>
					</tr>

					
					<tr>
						<td></td>
						<td><input id="add" type="submit" value="Envoyer" /></td>
					</tr>


					</form>

					</tr>

				</table>
			</fieldset>


			<fieldset>
				<legend>Liste des Places</legend>

				<table border="1" class="tab" style="width: 501px;">
					<thead>
						<tr>
							<th>Id</th>
							<th>code <br>
							<th>type</th>
							<th>prixParHeure</th>
							<th>supprimer</th>
							<th>modifier</th>
						</tr>
					</thead>
					<tbody id="content">
						<%
						SectionService ss = new SectionService();
						for (Section s : ss.findAll()) {
						%>
						<tr>
							<td><%=s.getId()%></td>
							<td><%=s.getCode()%></td>
							<td><%=s.getType()%></td>
							<td><%=s.getPrixParHeure()%></td>
							

							<td><a href="SectionController?id=<%=s.getId()%>&op=delete">Supprimer
							</a></td>
							<td><a href="SectionController?id=<%=s.getId()%>&op=update">Modifier
							</a></td>
						</tr>

						<%
						}
						%>
					</tbody>
				</table>

			</fieldset>
		</form>
	</div>

</footer>