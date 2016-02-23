package server;

import adapter.AutoServer;
import adapter.BuildAuto;

public class BuildCarModelOptions implements AutoServer {
	// Build Car Model Options class to build autos
	@Override
	public void buildCarModelOptions() throws Exception {
		AutoServer buildAuto = new BuildAuto();
		buildAuto.buildCarModelOptions();
	}

	@Override
	public String getAutoList() {
		AutoServer buildAuto = new BuildAuto();
		return buildAuto.getAutoList();
	}

}
