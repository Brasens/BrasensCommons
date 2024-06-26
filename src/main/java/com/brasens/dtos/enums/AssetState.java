package com.brasens.dtos.enums;

public enum AssetState {
	WORKING("Funcionando"), IDLE("Parado");

	private final String legend;

	AssetState(String legend) {
		this.legend = legend;
	}

	public String getLegend() {
		return legend;
	}

	public static AssetState getAssetState(String period) {
		switch (period) {
			case "Funcionando":
				return AssetState.WORKING;
			case "Parado":
				return AssetState.IDLE;
			default:
				throw new IllegalArgumentException("Período desconhecido: " + period);
		}
	}
}