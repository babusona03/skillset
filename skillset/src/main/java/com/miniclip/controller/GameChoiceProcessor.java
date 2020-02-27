package com.miniclip.controller;

import java.io.IOException;
import java.util.HashMap;
import javax.servlet.RequestDispatcher;
//import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.miniclip.model.DbConnection;
import com.miniclip.model.DbConnectionParameter;
import com.miniclip.model.LoginInfo;
import com.miniclip.model.OracleDbConnection;
import com.miniclip.model.OracleDbConnectionParameter;
import com.miniclip.model.OracleRPSDaoImpl;
import com.miniclip.model.RPSDao;
import com.miniclip.model.RPSData;
import com.miniclip.model.RpsLogic;

@WebServlet("/gamecontrol.do")
public class GameChoiceProcessor extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public GameChoiceProcessor() {
        super();
        // TODO Auto-generated constructor stub
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userChoice = request.getParameter("radio"); //receiving user choice
		HashMap<String,String> gameResult = new HashMap<String,String>();
		gameResult = RpsLogic.rpsLogic(userChoice);
		
		DbConnectionParameter dcp = new OracleDbConnectionParameter();
		
		LoginInfo loginInfo = new LoginInfo();
		loginInfo.setUserName(getServletContext().getInitParameter("oradbUid"));
		loginInfo.setPassword(getServletContext().getInitParameter("oradbPasswd"));
		
		
		
		dcp.setLoginInfo(loginInfo);
		dcp.setHostName(getServletContext().getInitParameter("oradbHostName"));
		dcp.setDriverType(getServletContext().getInitParameter("oradbDriverType"));
		dcp.setSid(getServletContext().getInitParameter("oradbSid"));
		dcp.setPort(getServletContext().getInitParameter("oradbPortNumber"));
		dcp.setUrl(getServletContext().getInitParameter("oradbUrl"));
		
		
		DbConnection dbc = new OracleDbConnection();
		dbc.setDcp(dcp);
		dbc.setConnectionUrl();
		dbc.setConnection();
		
		//check if connection created successfully
		if(dbc.getConnection()!=null){
			System.out.println("Connected To Db successfully.");
		}
		else{
			System.out.println("Connection Failed.");
		}
		//here, data gets persisted,
		//create rps system model RPS,=> RPsDao interface for procedures =>oracleRPSDaoImpl for ops.insert query and read query only.
		//list of resultset received here
		//after that,connection closes,control moves to view, current result and resultset forwarded to view 
		//el used to show present state data and previous data result table 
		
				
		String query = "INSERT INTO RPS_GAMEDATA(USER_CHOICE,SYSTEM_CHOICE,WINNER) VALUES"+"(?,?,?)";//have to fire insert query here
		RPSDao rpsDao= new OracleRPSDaoImpl();
		RPSData rpsData = new RPSData();
		rpsData.setUserChoice(gameResult.get("userChoice").toUpperCase());
		rpsData.setSystemChoice(gameResult.get("systemChoice").toUpperCase());
		rpsData.setWinner(gameResult.get("winner").toUpperCase());
		
		int result = rpsDao.insertRpsData(dbc.getConnection(), query, rpsData);
		System.out.println(""+result+" Row inserted.");
		request.setAttribute("gameResultStatus", gameResult.get("gameResultStatus"));
		request.setAttribute("winner", gameResult.get("winner"));
	
		if(dbc.closeConnection(false)==true){
			System.out.println("Connection closed successfully.");
		}
		else{
			System.out.println("Error in closing connection.");
		}
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/view/GameResult.jsp");
		view.forward(request, response);
	}
}