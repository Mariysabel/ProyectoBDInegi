/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.model;

/**
 *
 * @author MariySabel
 */
public class Vivienda {

    private int ENTIDAD;       // tinyint unsigned PK
    private int MUN;             // smallint unsigned PK
    private int LOC;             // int unsigned PK

    private int VIVTOT;
    private int TVIVHAB;
    private int TVIVPAR;

    private String VIVPAR_HAB;
    private String VIVPARH_CV;
    private String TVIVPARHAB;
    private String VIVPAR_DES;
    private String VIVPAR_UT;
    private String OCUPVIVPAR;

    // ----- Constructor vacío -----
    public Vivienda() {}

    // ----- Constructor completo -----
    public Vivienda(int ENTIDAD, int MUN, int LOC, int VIVTOT, int TVIVHAB, int TVIVPAR,
                    String VIVPAR_HAB, String VIVPARH_CV, String TVIVPARHAB,
                    String VIVPAR_DES, String VIVPAR_UT, String OCUPVIVPAR) {

        this.ENTIDAD = ENTIDAD;
        this.MUN = MUN;
        this.LOC = LOC;
        this.VIVTOT = VIVTOT;
        this.TVIVHAB = TVIVHAB;
        this.TVIVPAR = TVIVPAR;
        this.VIVPAR_HAB = VIVPAR_HAB;
        this.VIVPARH_CV = VIVPARH_CV;
        this.TVIVPARHAB = TVIVPARHAB;
        this.VIVPAR_DES = VIVPAR_DES;
        this.VIVPAR_UT = VIVPAR_UT;
        this.OCUPVIVPAR = OCUPVIVPAR;
    }

    // ----- Getters y Setters -----

    public int getENTIDAD() { return ENTIDAD; }
    public void setENTIDAD(short ENTIDAD) { this.ENTIDAD = ENTIDAD; }

    public int getMUN() { return MUN; }
    public void setMUN(int MUN) { this.MUN = MUN; }

    public int getLOC() { return LOC; }
    public void setLOC(int LOC) { this.LOC = LOC; }

    public int getVIVTOT() { return VIVTOT; }
    public void setVIVTOT(int VIVTOT) { this.VIVTOT = VIVTOT; }

    public int getTVIVHAB() { return TVIVHAB; }
    public void setTVIVHAB(int TVIVHAB) { this.TVIVHAB = TVIVHAB; }

    public int getTVIVPAR() { return TVIVPAR; }
    public void setTVIVPAR(int TVIVPAR) { this.TVIVPAR = TVIVPAR; }

    public String getVIVPAR_HAB() { return VIVPAR_HAB; }
    public void setVIVPAR_HAB(String VIVPAR_HAB) { this.VIVPAR_HAB = VIVPAR_HAB; }

    public String getVIVPARH_CV() { return VIVPARH_CV; }
    public void setVIVPARH_CV(String VIVPARH_CV) { this.VIVPARH_CV = VIVPARH_CV; }

    public String getTVIVPARHAB() { return TVIVPARHAB; }
    public void setTVIVPARHAB(String TVIVPARHAB) { this.TVIVPARHAB = TVIVPARHAB; }

    public String getVIVPAR_DES() { return VIVPAR_DES; }
    public void setVIVPAR_DES(String VIVPAR_DES) { this.VIVPAR_DES = VIVPAR_DES; }

    public String getVIVPAR_UT() { return VIVPAR_UT; }
    public void setVIVPAR_UT(String VIVPAR_UT) { this.VIVPAR_UT = VIVPAR_UT; }

    public String getOCUPVIVPAR() { return OCUPVIVPAR; }
    public void setOCUPVIVPAR(String OCUPVIVPAR) { this.OCUPVIVPAR = OCUPVIVPAR; }
}