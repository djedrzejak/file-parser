package pl.djedrzejak.parser.fileparser.enums;

public enum FileExtension {
	PRN,
	CSV;
	
	@Override
	public String toString() {
		return super.toString().toLowerCase();
	}
}
