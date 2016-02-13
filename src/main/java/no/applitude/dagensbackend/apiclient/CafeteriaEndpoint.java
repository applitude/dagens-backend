package no.applitude.dagensbackend.apiclient;

public enum CafeteriaEndpoint {
    ANDREA("285"),
    ANNAS("281"),
    ARKITEKTURHOEGSKOLEN("72"),
    AULARKJELLEREN("282"),
    FORSKNINGSVEIEN("283"),
    FREDERIKKE("122"),
    HANNAS("299"),
    HELAA("295"),
    IDRETTHOEGSKOLEN("157"),
    INFORMATEKET("158"),
    INFORMATIKK("284"),
    OLE("154"),
    AARSITDEN("296"),
    KUTT("310"),
    MEDICA("297"),
    MUSIKKHOEGSKOLEN("159"),
    ODONTOLOGI("298"),
    SEILDUKEN("155"),
    P35("71"),
    SV("153"),
    VETERINAERHOEGSKOLEN("160");
    
    private String value;
    
    CafeteriaEndpoint(String value) {
    	this.value = value;
    }
    
    public String value() {
    	return this.value;
    }
   
}
