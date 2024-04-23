package controllers;

import java.io.IOException;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utils.DButil;

import models.Message;

@WebServlet("/index")
public class indexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public indexServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
	        throws ServletException, IOException {
	    EntityManager em  = DButil.createEntityManager();
	    
	    List<Message> messages = em.createNamedQuery("getAllMessages", Message.class).getResultList();
	    response.getWriter().append(Integer.valueOf(messages.size()).toString());
	    
	    em.close();
	}

}
