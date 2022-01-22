<%@page import="beans.Section"%>
<%@page import="service.SectionService"%>
<footer class="footer pt-3  ">
	<div class="container-fluid">

		<link href="include3/style.css" rel="stylesheet" type="text/css" />
		<link href="include3/csslocal.css" rel="stylesheet" type="text/css" />

		<form action="TicketController" method="GET">

			<%@page import="service.PlaceService"%>
			<%@page import="service.SectionService"%>
			<%@page import="service.TicketService"%>
			<%@page import="beans.Place"%>
			<%@page import="beans.Ticket"%>
			<input id="id" type="hidden" name="id"
				value="<%=request.getParameter("id") == null ? "" : request.getParameter("id")%>"
				required="" style="width: 135px;" />
			<fieldset style="width: 588px;">
				<legend>Nouelle Ticket</legend>
				<table border="0">
					<tr>
						<td>heureDentrer</td>
						<td><input id="heureDentrer" type="text" name="heureDentrer"
							value="<%=request.getParameter("heureDentrer") == null ? "" : request.getParameter("heureDentrer")%>"
							required="" style="width: 135px;" /></td>
						<td style="width: 307px;">*</td>
					</tr>

					
				

					<tr>
						<td>Place</td>
						<td><select id="Place" name="Place" >
						<%
							PlaceService ps = new PlaceService();
							for (Place p : ps.findAll()) {
						%>
								<option  value="<%= p.getId() %>"><%= p %></option>
								<%}%>
						</select></td>
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
				<legend>  Liste des Tickets</legend>

				<table border="1" class="tab" style="width: 501px;">
					<thead>
						<tr>
							<th>Id</th>
							<th>heureDentrer</th>
							<th>Place</th>
							<th>supprimer</th>
							<th>modifier</th>
						</tr>
					</thead>
					<tbody id="content">
						<%
						TicketService ts = new TicketService();
						for (Ticket t : ts.findAll()) {

							
						%>
						<tr>
							<td><%=t.getId()%></td>
							<td><%=t.getHeureDentrer()%></td>
							<td><%=t.getPlace().getId()%></td>
							

							<td><a href="TicketController?id=<%=t.getId()%>&op=delete">Supprimer
							</a></td>
							<td><a href="TicketController?id=<%=t.getId()%>&op=update">Modifier
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