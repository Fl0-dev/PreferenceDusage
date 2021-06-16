package preferenceDUsage;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;




@WebServlet("/ServletTraitement")
public class ServletTraitement extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//traitement cookie cookieCompteur
		compteurAcces(request, response);
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/accueil.jsp");
		rd.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//traitement cookie cookieCompteur
		compteurAcces(request, response);
		// récupération de la couleur choisie dans le contexte de la session
		String choix = request.getParameter("choix");
		System.out.println(choix);
		// ouverture de session
		HttpSession session = request.getSession();
		//mise en attribut de session
		session.setAttribute("couleurChoisie",choix);
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/accueil.jsp");
		rd.forward(request, response);

	}
	private void compteurAcces(HttpServletRequest request, HttpServletResponse response) {
		//récupère la valeur du compteur dans un cookie s'il existe
		int compteurAcces = 1;
		//récupération du tableau de cookies
		Cookie[] cookies = request.getCookies();
		//si des cookies
		if (cookies!=null) {
			//pour tous les cookies
			for(Cookie c: cookies) {
				//si cookie avec comme nom compteurAcces
				if (c.getName().equals("compteurAcces")) {
					//on récpère sa valeur (String) qu'on passe en int qu'on incrémente
					compteurAcces = Integer.valueOf(c.getValue())+1;
					//on sort de la boucle
					break;
				}
			}
		}
		//on crée le cookie en dehors du tableau
		Cookie cookieCompteur = new Cookie("compteurAcces", String.valueOf(compteurAcces));
		cookieCompteur.setMaxAge(Integer.MAX_VALUE);
		//on l'ajoute dans la réponse
		response.addCookie(cookieCompteur);
		//on le met en attribut de requête pour récupérer dans la jsp
		request.setAttribute("compteurAcces", compteurAcces);
		
	}

}
