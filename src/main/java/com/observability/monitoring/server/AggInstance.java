package com.observability.monitoring.server;

public class AggInstance {

	// The configuration elements
	private String plugin; 			// The collectd plugin on which data will be  aggregated. For example: plugin = cpu
	private String pluginInstance; 	
	private String type;
	private String typeInst; 		// The type of metric on which data will be aggregated. For example: cpu-system, spu-idle
	
	// Function of aggregation
	private boolean calNum; 
	private boolean calSum; 		// The status of the sum calculation of all measurement for the specified metric
	private boolean calAvg; 		// The status of the average calculation of all measurement for the specified metric
	private boolean calMin; 		// The status of the minimum calculation of all measurement for the specified metric
	private boolean calMax; 		// The status of the maximum calculation of all measurement for the specified metric
	private boolean calStd; 		// The status of the standard deviation calculation of all measurement for the specified metric
	
	// Values of aggregations
	private double measurementNum;	// The result of Num of the measurements of all nodes
	private double measurementSum;	// The result of Sum of the measurements of all nodes
	private double measurementAvg;	// The result of Avg of the measurements of all nodes
	private double measurementMin; 	// The result of Min of the measurements of all nodes
	private double measurementMax;	// The result of Max of the measurements of all nodes
	private double measurementStd;	// The result of Standard Deviation of the measurements of all nodes
		    	
	private String aggTimeStampStartStr;	// Time stamp of the aggregated values 
	
	/**
	 * @param aggTimeStampStartStr
	 * @param plugin
	 * @param pluginInstance
	 * @param type
	 * @param typeInst
	 * @param calNum
	 * @param calSum
	 * @param calAvg
	 * @param calMin
	 * @param calMax
	 * @param calStd
	 * @param measurementSum
	 * @param measurementAvg
	 * @param measurementMin
	 * @param measurementMax
	 * @param measurementStd
	 */
	public AggInstance(String aggTimeStampStartStr, String plugin,
			String pluginInstance, String type, String typeInst,
			boolean calNum, boolean calSum, boolean calAvg, boolean calMin, boolean calMax,
			boolean calStd, double measurementNum, double measurementSum, double measurementAvg,
			double measurementMin, double measurementMax, double measurementStd) {
		super();
		this.aggTimeStampStartStr = aggTimeStampStartStr;
		this.plugin = plugin;
		this.pluginInstance = pluginInstance;
		this.type = type;
		this.typeInst = typeInst;
		this.calNum = calNum;
		this.calSum = calSum;
		this.calAvg = calAvg;
		this.calMin = calMin;
		this.calMax = calMax;
		this.calStd = calStd;
		this.measurementNum = measurementNum;
		this.measurementSum = measurementSum;
		this.measurementAvg = measurementAvg;
		this.measurementMin = measurementMin;
		this.measurementMax = measurementMax;
		this.measurementStd = measurementStd;
	}
	
	public AggInstance(double measurementNum, double measurementSum, double measurementAvg,
			double measurementMin, double measurementMax, double measurementStd) {
		super();
		this.measurementNum = measurementNum;
		this.measurementSum = measurementSum;
		this.measurementAvg = measurementAvg;
		this.measurementMin = measurementMin;
		this.measurementMax = measurementMax;
		this.measurementStd = measurementStd;
	}
	/**
	 * @return the plugin
	 */
	public String getPlugin() {
		return plugin;
	}
	/**
	 * @param plugin the plugin to set
	 */
	public void setPlugin(String plugin) {
		this.plugin = plugin;
	}
	/**
	 * @return the pluginInstance
	 */
	public String getPluginInstance() {
		return pluginInstance;
	}
	/**
	 * @param pluginInstance the pluginInstance to set
	 */
	public void setPluginInstance(String pluginInstance) {
		this.pluginInstance = pluginInstance;
	}
	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * @return the typeInst
	 */
	public String getTypeInst() {
		return typeInst;
	}
	/**
	 * @param typeInst the typeInst to set
	 */
	public void setTypeInst(String typeInst) {
		this.typeInst = typeInst;
	}
	/**
	 * @return the calNum
	 */
	public boolean isCalNum() {
		return calSum;
	}
	/**
	 * @param calNum the calNum to set
	 */
	public void setCalNum(boolean calNum) {
		this.calNum = calNum;
	}
	/**
	 * @return the calSum
	 */
	public boolean isCalSum() {
		return calSum;
	}
	/**
	 * @param calSum the calSum to set
	 */
	public void setCalSum(boolean calSum) {
		this.calSum = calSum;
	}
	/**
	 * @return the calAvg
	 */
	public boolean isCalAvg() {
		return calAvg;
	}
	/**
	 * @param calAvg the calAvg to set
	 */
	public void setCalAvg(boolean calAvg) {
		this.calAvg = calAvg;
	}
	/**
	 * @return the calMin
	 */
	public boolean isCalMin() {
		return calMin;
	}
	/**
	 * @param calMin the calMin to set
	 */
	public void setCalMin(boolean calMin) {
		this.calMin = calMin;
	}
	/**
	 * @return the calMax
	 */
	public boolean isCalMax() {
		return calMax;
	}
	/**
	 * @param calMax the calMax to set
	 */
	public void setCalMax(boolean calMax) {
		this.calMax = calMax;
	}
	/**
	 * @return the calStd
	 */
	public boolean isCalStd() {
		return calStd;
	}
	/**
	 * @param calStd the calStd to set
	 */
	public void setCalStd(boolean calStd) {
		this.calStd = calStd;
	}
	
	/**
	 * @return the measurementNum
	 */
	public double getMeasurementNum() {
		return measurementSum;
	}
	/**
	 * @param measurementNum the measurementNum to set
	 */
	public void setMeasurementNum(double measurementNum) {
		this.measurementNum = measurementNum;
	}
	/**
	 * @return the measurementSum
	 */
	public double getMeasurementSum() {
		return measurementSum;
	}
	/**
	 * @param measurementSum the measurementSum to set
	 */
	public void setMeasurementSum(double measurementSum) {
		this.measurementSum = measurementSum;
	}
	/**
	 * @return the measurementAvg
	 */
	public double getMeasurementAvg() {
		return measurementAvg;
	}
	/**
	 * @param measurementAvg the measurementAvg to set
	 */
	public void setMeasurementAvg(double measurementAvg) {
		this.measurementAvg = measurementAvg;
	}
	/**
	 * @return the measurementMin
	 */
	public double getMeasurementMin() {
		return measurementMin;
	}
	/**
	 * @param measurementMin the measurementMin to set
	 */
	public void setMeasurementMin(double measurementMin) {
		this.measurementMin = measurementMin;
	}
	/**
	 * @return the measurementMax
	 */
	public double getMeasurementMax() {
		return measurementMax;
	}
	/**
	 * @param measurementMax the measurementMax to set
	 */
	public void setMeasurementMax(double measurementMax) {
		this.measurementMax = measurementMax;
	}
	/**
	 * @return the measurementStd
	 */
	public double getMeasurementStd() {
		return measurementStd;
	}
	/**
	 * @param measurementStd the measurementStd to set
	 */
	public void setMeasurementStd(double measurementStd) {
		this.measurementStd = measurementStd;
	}
	/**
	 * @return the aggTimeStampStartStr
	 */
	public String getAggTimeStampStartStr() {
		return aggTimeStampStartStr;
	}
	/**
	 * @param aggTimeStampStartStr the aggTimeStampStartStr to set
	 */
	public void setAggTimeStampStartStr(String aggTimeStampStartStr) {
		this.aggTimeStampStartStr = aggTimeStampStartStr;
	}
}