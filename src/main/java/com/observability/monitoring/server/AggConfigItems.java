package com.observability.monitoring.server;

import java.io.Serializable;

public class AggConfigItems implements Serializable{
   
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

		// Configuration items variables 
		//int ident;			

	    private int interval;		// The interval of the aggregation
	    private String plugin;		// The collectd plugin on which data will be aggregated. For example: plugin = cpu
	    private String typeInst;	// The type of metric on which data will be aggregated. For example: cpu-system 

	    // Type of aggregation
	    private boolean calNum;		// ?
	    private boolean calSum;		// Calculate the sum of all measurement for the specified metric
	    private boolean calAvg;		// Calculate the average of all measurement for the specified metric
	    private boolean calMin;		// Calculate the minimum of all measurement for the specified metric
	    private boolean calMax;		// Calculate the maximum of all measurement for the specified metric
	    private boolean calStd;		// Calculate the standard deviation of all measurement for the specified metric
		
	    
	    /**
	     * Constructor to set the variables
	     * @param plugin is metric 
	     * @param typeInst is metric type
	     * @param calNum 
	     * @param calSum is to calculate the sum 
	     * @param calAvg is to calculate the average
	     * @param calMin is to calculate the minimum
	     * @param calMax is to calculate the maximum
	     * @param calStd is to calculate the standard deviation    
	     */
	    public AggConfigItems(int interval, String plugin,
				String typeInst, boolean calNum, boolean calSum, boolean calAvg,
				boolean calMin, boolean calMax, boolean calStd) {
			super();
			//this.ident = ident;
			this.interval = interval;
			this.plugin = plugin;
			this.typeInst = typeInst;
			this.calNum = calNum;
			this.calSum = calSum;
			this.calAvg = calAvg;
			this.calMin = calMin;
			this.calMax = calMax;
			this.calStd = calStd;
		}

	    
	    /**
	     *    
	     *//*
	    public int getIdent() {
			return ident;
		}

	    *//**
	     *    
	     *//*
		public void setIdent(int ident) {
			this.ident = ident;
		}*/

		/**
	     *    
	     */
		public int getInterval() {
			return interval;
		}

		/**
	     *    
	     */
		public void setInterval(int interval) {
			this.interval = interval;
		}

		/**
	     *    
	     */
		public String getPlugin() {
			return plugin;
		}


		/**
	     *    
	     */
		public void setPlugin(String plugin) {
			this.plugin = plugin;
		}


		/**
	     *    
	     */
		public String getTypeInst() {
			return typeInst;
		}


		/**
	     *    
	     */
		public void setTypeInst(String typeInst) {
			this.typeInst = typeInst;
		}

		/**
	     *    
	     */
		public boolean isCalNum() {
			return calNum;
		}


		/**
	     *    
	     */
		public void setCalNum(boolean calNum) {
			this.calNum = calNum;
		}

		/**
	     *    
	     */
		public boolean isCalSum() {
			return calSum;
		}


		/**
	     *    
	     */
		public void setCalSum(boolean calSum) {
			this.calSum = calSum;
		}

		/**
	     *    
	     */
		public boolean isCalAvg() {
			return calAvg;
		}


		/**
	     *    
	     */
		public void setCalAvg(boolean calAvg) {
			this.calAvg = calAvg;
		}

		
		/**
	     *    
	     */
		public boolean isCalMin() {
			return calMin;
		}


		/**
	     *    
	     */
		public void setCalMin(boolean calMin) {
			this.calMin = calMin;
		}

		
		/**
	     *    
	     */
		public boolean isCalMax() {
			return calMax;
		}


		/**
	     *    
	     */
		public void setCalMax(boolean calMax) {
			this.calMax = calMax;
		}

		/**
	     *    
	     */
		public boolean isCalStd() {
			return calStd;
		}


		/**
	     *    
	     */
		public void setCalStd(boolean calStd) {
			this.calStd = calStd;
		}
 
}
