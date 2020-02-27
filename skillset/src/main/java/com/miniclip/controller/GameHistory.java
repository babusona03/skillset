package com.miniclip.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
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

/**
 * Servlet implementation class GameHistory
 */
@WebServlet("/gamedata.do")
public class GameHistory extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GameHistory() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
DbConnectionParameter dcp = new OracleDbConnectionParameter();
		
		LoginInfo loginInfo = new LoginInfo();
		RequestDispatcher view = null;
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
		//System.out.println(" "+dbc.getConnectionUrl());
		//check if connection created successfully
		if(dbc.getConnection()!=null){
			System.out.println("Connected To Db successfully.");
		}
		else{
			System.out.println("Connection Failed.");
		}
		//here, data gets persisted,
		//create rps system model RPS,=> RPsDao interface for procedures =>oracleRPSDaoImpl for ops.insert and read only.
		//list of resultset received here
		//after that,connection closes,control moves to view, current result and resultsetforwarded to view 
		//el used to show present state data and previous data result table 
		
		//a dummy read query to check db connection
		String query = "SELECT * FROM rps_gamedata ORDER BY serial";
		RPSDao rpsDao= new OracleRPSDaoImpl();
		List<RPSData> result = rpsDao.readRpsData(dbc.getConnection(), query);
		for(RPSData rpsData : result){
			System.out.println(""+rpsData.getSerial()+" "+rpsData.getUserChoice()+" "+rpsData.getSystemChoice()+" "+rpsData.getTimeStamp()+" "+rpsData.getWinner());
		}
		request.setAttribute("result", result);
		
		///closing connection
		
		if(dbc.closeConnection(false)==true){
			System.out.println("Connection closed successfully.");
		}
		else{
			System.out.println("Error in closing connection.");
		}
		view=request.getRequestDispatcher("WEB-INF/view/RpsHistory.jsp");
		view.forward(request, response);
	}

}
