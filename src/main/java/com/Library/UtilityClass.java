package com.Library;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
//import org.testng.annotations.Configuration;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


public class UtilityClass	{

	
	   // alert.accept();
	 public static WebDriver driver;
	 public String  baseUrl = "https://192.168.10.72/#/login";
	 //Sebastian
	// protected  String downloadPath="d:\\selenium_downloads";
	 //Manoj
	protected  String downloadPath="E:\\selenium_downloads";
	 
	 int i=0;
	
	 private static final int TIMEOUT = 20000;
	 protected String Supertent_Login_id="Shinto-Test";
	 protected String Supertent_Login_Password="Password1!"; 
	 
	@BeforeTest
	 public void setup1() throws Exception
	 { 
		
		
		//Sebastian
		//System.setProperty("webdriver.gecko.driver","D:\\Jars\\Drivers\\New-geckodriver\\geckodriver.exe");
		//Akhil 
		System.setProperty("webdriver.gecko.driver", "E:\\Edinsight\\geckodriver.exe");
		//Manoj
		System.setProperty("webdriver.gecko.driver", "f:\\Jars\\geckodriver.exe");
		//Server
		System.setProperty("webdriver.gecko.driver", "e:\\Jars\\geckodriver.exe");
		
		
		
		FirefoxProfile profile = new FirefoxProfile();
		profile.setPreference("browser.download.folderList", 2);
		profile.setPreference("browser.download.dir",downloadPath);
		profile.setPreference("browser.download.manager.alertOnEXEOpen", false);
		profile.setPreference("browser.helperApps.neverAsk.openFile", false);
        profile.setPreference("browser.helperApps.neverAsk.saveToDisk", "application/csv;text/csv;application/vnd.hzn-3d-crossword;video/3gpp;video/3gpp2;application/vnd.mseq;application/vnd.3m.post-it-notes;application/vnd.3gpp.pic-bw-large;application/vnd.3gpp.pic-bw-small;application/vnd.3gpp.pic-bw-var;application/vnd.3gp2.tcap;application/x-7z-compressed;application/x-abiword;application/x-ace-compressed;application/vnd.americandynamics.acc;application/vnd.acucobol;application/vnd.acucorp;audio/adpcm;application/x-authorware-bin;application/x-athorware-map;application/x-authorware-seg;application/vnd.adobe.air-application-installer-package+zip;application/x-shockwave-flash;application/vnd.adobe.fxp;application/pdf;application/vnd.cups-ppd;application/x-director;applicaion/vnd.adobe.xdp+xml;application/vnd.adobe.xfdf;audio/x-aac;application/vnd.ahead.space;application/vnd.airzip.filesecure.azf;application/vnd.airzip.filesecure.azs;application/vnd.amazon.ebook;application/vnd.amiga.ami;applicatin/andrew-inset;application/vnd.android.package-archive;application/vnd.anser-web-certificate-issue-initiation;application/vnd.anser-web-funds-transfer-initiation;application/vnd.antix.game-component;application/vnd.apple.installe+xml;application/applixware;application/vnd.hhe.lesson-player;application/vnd.aristanetworks.swi;text/x-asm;application/atomcat+xml;application/atomsvc+xml;application/atom+xml;application/pkix-attr-cert;audio/x-aiff;video/x-msvieo;application/vnd.audiograph;image/vnd.dxf;model/vnd.dwf;text/plain-bas;application/x-bcpio;application/octet-stream;image/bmp;application/x-bittorrent;application/vnd.rim.cod;application/vnd.blueice.multipass;application/vnd.bm;application/x-sh;image/prs.btif;application/vnd.businessobjects;application/x-bzip;application/x-bzip2;application/x-csh;text/x-c;application/vnd.chemdraw+xml;text/css;chemical/x-cdx;chemical/x-cml;chemical/x-csml;application/vn.contact.cmsg;application/vnd.claymore;application/vnd.clonk.c4group;image/vnd.dvb.subtitle;application/cdmi-capability;application/cdmi-container;application/cdmi-domain;application/cdmi-object;application/cdmi-queue;applicationvnd.cluetrust.cartomobile-config;application/vnd.cluetrust.cartomobile-config-pkg;image/x-cmu-raster;model/vnd.collada+xml;text/csv;application/mac-compactpro;application/vnd.wap.wmlc;image/cgm;x-conference/x-cooltalk;image/x-cmx;application/vnd.xara;application/vnd.cosmocaller;application/x-cpio;application/vnd.crick.clicker;application/vnd.crick.clicker.keyboard;application/vnd.crick.clicker.palette;application/vnd.crick.clicker.template;application/vn.crick.clicker.wordbank;application/vnd.criticaltools.wbs+xml;application/vnd.rig.cryptonote;chemical/x-cif;chemical/x-cmdf;application/cu-seeme;application/prs.cww;text/vnd.curl;text/vnd.curl.dcurl;text/vnd.curl.mcurl;text/vnd.crl.scurl;application/vnd.curl.car;application/vnd.curl.pcurl;application/vnd.yellowriver-custom-menu;application/dssc+der;application/dssc+xml;application/x-debian-package;audio/vnd.dece.audio;image/vnd.dece.graphic;video/vnd.dec.hd;video/vnd.dece.mobile;video/vnd.uvvu.mp4;video/vnd.dece.pd;video/vnd.dece.sd;video/vnd.dece.video;application/x-dvi;application/vnd.fdsn.seed;application/x-dtbook+xml;application/x-dtbresource+xml;application/vnd.dvb.ait;applcation/vnd.dvb.service;audio/vnd.digital-winds;image/vnd.djvu;application/xml-dtd;application/vnd.dolby.mlp;application/x-doom;application/vnd.dpgraph;audio/vnd.dra;application/vnd.dreamfactory;audio/vnd.dts;audio/vnd.dts.hd;imag/vnd.dwg;application/vnd.dynageo;application/ecmascript;application/vnd.ecowin.chart;image/vnd.fujixerox.edmics-mmr;image/vnd.fujixerox.edmics-rlc;application/exi;application/vnd.proteus.magazine;application/epub+zip;message/rfc82;application/vnd.enliven;application/vnd.is-xpr;image/vnd.xiff;application/vnd.xfdl;application/emma+xml;application/vnd.ezpix-album;application/vnd.ezpix-package;image/vnd.fst;video/vnd.fvt;image/vnd.fastbidsheet;application/vn.denovo.fcselayout-link;video/x-f4v;video/x-flv;image/vnd.fpx;image/vnd.net-fpx;text/vnd.fmi.flexstor;video/x-fli;application/vnd.fluxtime.clip;application/vnd.fdf;text/x-fortran;application/vnd.mif;application/vnd.framemaker;imae/x-freehand;application/vnd.fsc.weblaunch;application/vnd.frogans.fnc;application/vnd.frogans.ltf;application/vnd.fujixerox.ddd;application/vnd.fujixerox.docuworks;application/vnd.fujixerox.docuworks.binder;application/vnd.fujitu.oasys;application/vnd.fujitsu.oasys2;application/vnd.fujitsu.oasys3;application/vnd.fujitsu.oasysgp;application/vnd.fujitsu.oasysprs;application/x-futuresplash;application/vnd.fuzzysheet;image/g3fax;application/vnd.gmx;model/vn.gtw;application/vnd.genomatix.tuxedo;application/vnd.geogebra.file;application/vnd.geogebra.tool;model/vnd.gdl;application/vnd.geometry-explorer;application/vnd.geonext;application/vnd.geoplan;application/vnd.geospace;applicatio/x-font-ghostscript;application/x-font-bdf;application/x-gtar;application/x-texinfo;application/x-gnumeric;application/vnd.google-earth.kml+xml;application/vnd.google-earth.kmz;application/vnd.grafeq;image/gif;text/vnd.graphviz;aplication/vnd.groove-account;application/vnd.groove-help;application/vnd.groove-identity-message;application/vnd.groove-injector;application/vnd.groove-tool-message;application/vnd.groove-tool-template;application/vnd.groove-vcar;video/h261;video/h263;video/h264;application/vnd.hp-hpid;application/vnd.hp-hps;application/x-hdf;audio/vnd.rip;application/vnd.hbci;application/vnd.hp-jlyt;application/vnd.hp-pcl;application/vnd.hp-hpgl;application/vnd.yamaha.h-script;application/vnd.yamaha.hv-dic;application/vnd.yamaha.hv-voice;application/vnd.hydrostatix.sof-data;application/hyperstudio;application/vnd.hal+xml;text/html;application/vnd.ibm.rights-management;application/vnd.ibm.securecontainer;text/calendar;application/vnd.iccprofile;image/x-icon;application/vnd.igloader;image/ief;application/vnd.immervision-ivp;application/vnd.immervision-ivu;application/reginfo+xml;text/vnd.in3d.3dml;text/vnd.in3d.spot;mode/iges;application/vnd.intergeo;application/vnd.cinderella;application/vnd.intercon.formnet;application/vnd.isac.fcs;application/ipfix;application/pkix-cert;application/pkixcmp;application/pkix-crl;application/pkix-pkipath;applicaion/vnd.insors.igm;application/vnd.ipunplugged.rcprofile;application/vnd.irepository.package+xml;text/vnd.sun.j2me.app-descriptor;application/java-archive;application/java-vm;application/x-java-jnlp-file;application/java-serializd-object;text/x-java-source,java;application/javascript;application/json;application/vnd.joost.joda-archive;video/jpm;image/jpeg;video/jpeg;application/vnd.kahootz;application/vnd.chipnuts.karaoke-mmd;application/vnd.kde.karbon;aplication/vnd.kde.kchart;application/vnd.kde.kformula;application/vnd.kde.kivio;application/vnd.kde.kontour;application/vnd.kde.kpresenter;application/vnd.kde.kspread;application/vnd.kde.kword;application/vnd.kenameaapp;applicatin/vnd.kidspiration;application/vnd.kinar;application/vnd.kodak-descriptor;application/vnd.las.las+xml;application/x-latex;application/vnd.llamagraphics.life-balance.desktop;application/vnd.llamagraphics.life-balance.exchange+xml;application/vnd.jam;application/vnd.lotus-1-2-3;application/vnd.lotus-approach;application/vnd.lotus-freelance;application/vnd.lotus-notes;application/vnd.lotus-organizer;application/vnd.lotus-screencam;application/vnd.lotus-wordro;audio/vnd.lucent.voice;audio/x-mpegurl;video/x-m4v;application/mac-binhex40;application/vnd.macports.portpkg;application/vnd.osgeo.mapguide.package;application/marc;application/marcxml+xml;application/mxf;application/vnd.wolfrm.player;application/mathematica;application/mathml+xml;application/mbox;application/vnd.medcalcdata;application/mediaservercontrol+xml;application/vnd.mediastation.cdkey;application/vnd.mfer;application/vnd.mfmp;model/mesh;appliation/mads+xml;application/mets+xml;application/mods+xml;application/metalink4+xml;application/vnd.ms-powerpoint.template.macroenabled.12;application/vnd.ms-word.document.macroenabled.12;application/vnd.ms-word.template.macroenabed.12;application/vnd.mcd;application/vnd.micrografx.flo;application/vnd.micrografx.igx;application/vnd.eszigno3+xml;application/x-msaccess;video/x-ms-asf;application/x-msdownload;application/vnd.ms-artgalry;application/vnd.ms-ca-compressed;application/vnd.ms-ims;application/x-ms-application;application/x-msclip;image/vnd.ms-modi;application/vnd.ms-fontobject;application/vnd.ms-excel;application/vnd.ms-excel.addin.macroenabled.12;application/vnd.ms-excelsheet.binary.macroenabled.12;application/vnd.ms-excel.template.macroenabled.12;application/vnd.ms-excel.sheet.macroenabled.12;application/vnd.ms-htmlhelp;application/x-mscardfile;application/vnd.ms-lrm;application/x-msmediaview;aplication/x-msmoney;application/vnd.openxmlformats-officedocument.presentationml.presentation;application/vnd.openxmlformats-officedocument.presentationml.slide;application/vnd.openxmlformats-officedocument.presentationml.slideshw;application/vnd.openxmlformats-officedocument.presentationml.template;application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;application/vnd.openxmlformats-officedocument.spreadsheetml.template;application/vnd.openxmformats-officedocument.wordprocessingml.document;application/vnd.openxmlformats-officedocument.wordprocessingml.template;application/x-msbinder;application/vnd.ms-officetheme;application/onenote;audio/vnd.ms-playready.media.pya;vdeo/vnd.ms-playready.media.pyv;application/vnd.ms-powerpoint;application/vnd.ms-powerpoint.addin.macroenabled.12;application/vnd.ms-powerpoint.slide.macroenabled.12;application/vnd.ms-powerpoint.presentation.macroenabled.12;appliation/vnd.ms-powerpoint.slideshow.macroenabled.12;application/vnd.ms-project;application/x-mspublisher;application/x-msschedule;application/x-silverlight-app;application/vnd.ms-pki.stl;application/vnd.ms-pki.seccat;application/vn.visio;video/x-ms-wm;audio/x-ms-wma;audio/x-ms-wax;video/x-ms-wmx;application/x-ms-wmd;application/vnd.ms-wpl;application/x-ms-wmz;video/x-ms-wmv;video/x-ms-wvx;application/x-msmetafile;application/x-msterminal;application/msword;application/x-mswrite;application/vnd.ms-works;application/x-ms-xbap;application/vnd.ms-xpsdocument;audio/midi;application/vnd.ibm.minipay;application/vnd.ibm.modcap;application/vnd.jcp.javame.midlet-rms;application/vnd.tmobile-ivetv;application/x-mobipocket-ebook;application/vnd.mobius.mbk;application/vnd.mobius.dis;application/vnd.mobius.plc;application/vnd.mobius.mqy;application/vnd.mobius.msl;application/vnd.mobius.txf;application/vnd.mobius.daf;tex/vnd.fly;application/vnd.mophun.certificate;application/vnd.mophun.application;video/mj2;audio/mpeg;video/vnd.mpegurl;video/mpeg;application/mp21;audio/mp4;video/mp4;application/mp4;application/vnd.apple.mpegurl;application/vnd.msician;application/vnd.muvee.style;application/xv+xml;application/vnd.nokia.n-gage.data;application/vnd.nokia.n-gage.symbian.install;application/x-dtbncx+xml;application/x-netcdf;application/vnd.neurolanguage.nlu;application/vnd.na;application/vnd.noblenet-directory;application/vnd.noblenet-sealer;application/vnd.noblenet-web;application/vnd.nokia.radio-preset;application/vnd.nokia.radio-presets;text/n3;application/vnd.novadigm.edm;application/vnd.novadim.edx;application/vnd.novadigm.ext;application/vnd.flographit;audio/vnd.nuera.ecelp4800;audio/vnd.nuera.ecelp7470;audio/vnd.nuera.ecelp9600;application/oda;application/ogg;audio/ogg;video/ogg;application/vnd.oma.dd2+xml;applicatin/vnd.oasis.opendocument.text-web;application/oebps-package+xml;application/vnd.intu.qbo;application/vnd.openofficeorg.extension;application/vnd.yamaha.openscoreformat;audio/webm;video/webm;application/vnd.oasis.opendocument.char;application/vnd.oasis.opendocument.chart-template;application/vnd.oasis.opendocument.database;application/vnd.oasis.opendocument.formula;application/vnd.oasis.opendocument.formula-template;application/vnd.oasis.opendocument.grapics;application/vnd.oasis.opendocument.graphics-template;application/vnd.oasis.opendocument.image;application/vnd.oasis.opendocument.image-template;application/vnd.oasis.opendocument.presentation;application/vnd.oasis.opendocumen.presentation-template;application/vnd.oasis.opendocument.spreadsheet;application/vnd.oasis.opendocument.spreadsheet-template;application/vnd.oasis.opendocument.text;application/vnd.oasis.opendocument.text-master;application/vnd.asis.opendocument.text-template;image/ktx;application/vnd.sun.xml.calc;application/vnd.sun.xml.calc.template;application/vnd.sun.xml.draw;application/vnd.sun.xml.draw.template;application/vnd.sun.xml.impress;application/vnd.sun.xl.impress.template;application/vnd.sun.xml.math;application/vnd.sun.xml.writer;application/vnd.sun.xml.writer.global;application/vnd.sun.xml.writer.template;application/x-font-otf;application/vnd.yamaha.openscoreformat.osfpvg+xml;application/vnd.osgi.dp;application/vnd.palm;text/x-pascal;application/vnd.pawaafile;application/vnd.hp-pclxl;application/vnd.picsel;image/x-pcx;image/vnd.adobe.photoshop;application/pics-rules;image/x-pict;application/x-chat;aplication/pkcs10;application/x-pkcs12;application/pkcs7-mime;application/pkcs7-signature;application/x-pkcs7-certreqresp;application/x-pkcs7-certificates;application/pkcs8;application/vnd.pocketlearn;image/x-portable-anymap;image/-portable-bitmap;application/x-font-pcf;application/font-tdpfr;application/x-chess-pgn;image/x-portable-graymap;image/png;image/x-portable-pixmap;application/pskc+xml;application/vnd.ctc-posml;application/postscript;application/xfont-type1;application/vnd.powerbuilder6;application/pgp-encrypted;application/pgp-signature;application/vnd.previewsystems.box;application/vnd.pvi.ptid1;application/pls+xml;application/vnd.pg.format;application/vnd.pg.osasli;tex/prs.lines.tag;application/x-font-linux-psf;application/vnd.publishare-delta-tree;application/vnd.pmi.widget;application/vnd.quark.quarkxpress;application/vnd.epson.esf;application/vnd.epson.msf;application/vnd.epson.ssf;applicaton/vnd.epson.quickanime;application/vnd.intu.qfx;video/quicktime;application/x-rar-compressed;audio/x-pn-realaudio;audio/x-pn-realaudio-plugin;application/rsd+xml;application/vnd.rn-realmedia;application/vnd.realvnc.bed;applicatin/vnd.recordare.musicxml;application/vnd.recordare.musicxml+xml;application/relax-ng-compact-syntax;application/vnd.data-vision.rdz;application/rdf+xml;application/vnd.cloanto.rp9;application/vnd.jisp;application/rtf;text/richtex;application/vnd.route66.link66+xml;application/rss+xml;application/shf+xml;application/vnd.sailingtracker.track;image/svg+xml;application/vnd.sus-calendar;application/sru+xml;application/set-payment-initiation;application/set-reistration-initiation;application/vnd.sema;application/vnd.semd;application/vnd.semf;application/vnd.seemail;application/x-font-snf;application/scvp-vp-request;application/scvp-vp-response;application/scvp-cv-request;application/svp-cv-response;application/sdp;text/x-setext;video/x-sgi-movie;application/vnd.shana.informed.formdata;application/vnd.shana.informed.formtemplate;application/vnd.shana.informed.interchange;application/vnd.shana.informed.package;application/thraud+xml;application/x-shar;image/x-rgb;application/vnd.epson.salt;application/vnd.accpac.simply.aso;application/vnd.accpac.simply.imp;application/vnd.simtech-mindmapper;application/vnd.commonspace;application/vnd.ymaha.smaf-audio;application/vnd.smaf;application/vnd.yamaha.smaf-phrase;application/vnd.smart.teacher;application/vnd.svd;application/sparql-query;application/sparql-results+xml;application/srgs;application/srgs+xml;application/sml+xml;application/vnd.koan;text/sgml;application/vnd.stardivision.calc;application/vnd.stardivision.draw;application/vnd.stardivision.impress;application/vnd.stardivision.math;application/vnd.stardivision.writer;application/vnd.tardivision.writer-global;application/vnd.stepmania.stepchart;application/x-stuffit;application/x-stuffitx;application/vnd.solent.sdkm+xml;application/vnd.olpc-sugar;audio/basic;application/vnd.wqd;application/vnd.symbian.install;application/smil+xml;application/vnd.syncml+xml;application/vnd.syncml.dm+wbxml;application/vnd.syncml.dm+xml;application/x-sv4cpio;application/x-sv4crc;application/sbml+xml;text/tab-separated-values;image/tiff;application/vnd.to.intent-module-archive;application/x-tar;application/x-tcl;application/x-tex;application/x-tex-tfm;application/tei+xml;text/plain;application/vnd.spotfire.dxp;application/vnd.spotfire.sfs;application/timestamped-data;applicationvnd.trid.tpt;application/vnd.triscape.mxs;text/troff;application/vnd.trueapp;application/x-font-ttf;text/turtle;application/vnd.umajin;application/vnd.uoml+xml;application/vnd.unity;application/vnd.ufdl;text/uri-list;application/nd.uiq.theme;application/x-ustar;text/x-uuencode;text/x-vcalendar;text/x-vcard;application/x-cdlink;application/vnd.vsf;model/vrml;application/vnd.vcx;model/vnd.mts;model/vnd.vtu;application/vnd.visionary;video/vnd.vivo;applicatin/ccxml+xml,;application/voicexml+xml;application/x-wais-source;application/vnd.wap.wbxml;image/vnd.wap.wbmp;audio/x-wav;application/davmount+xml;application/x-font-woff;application/wspolicy+xml;image/webp;application/vnd.webturb;application/widget;application/winhlp;text/vnd.wap.wml;text/vnd.wap.wmlscript;application/vnd.wap.wmlscriptc;application/vnd.wordperfect;application/vnd.wt.stf;application/wsdl+xml;image/x-xbitmap;image/x-xpixmap;image/x-xwindowump;application/x-x509-ca-cert;application/x-xfig;application/xhtml+xml;application/xml;application/xcap-diff+xml;application/xenc+xml;application/patch-ops-error+xml;application/resource-lists+xml;application/rls-services+xml;aplication/resource-lists-diff+xml;application/xslt+xml;application/xop+xml;application/x-xpinstall;application/xspf+xml;application/vnd.mozilla.xul+xml;chemical/x-xyz;text/yaml;application/yang;application/yin+xml;application/vnd.ul;application/zip;application/vnd.handheld-entertainment+xml;application/vnd.zzazz.deck+xml");

		profile.setPreference("browser.download.manager.showWhenStarting", false);
		profile.setPreference("browser.download.manager.focusWhenStarting", false);
		profile.setPreference("browser.download.useDownloadDir", true);
		profile.setPreference("browser.helperApps.alwaysAsk.force", false);
		profile.setPreference("browser.download.manager.alertOnEXEOpen", false);
		profile.setPreference("browser.download.manager.closeWhenDone", true);
		profile.setPreference("browser.download.manager.showAlertOnComplete", false);
		profile.setPreference("browser.download.manager.useWindow", false);
		profile.setPreference("services.sync.prefs.sync.browser.download.manager.showWhenStarting", false);
		profile.setPreference("pdfjs.disabled", true);
		
		FirefoxOptions option=new FirefoxOptions();
		option.setProfile(profile);
		
        driver = new FirefoxDriver(option);
        
        
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);		
		//driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.get(baseUrl);
		  
	 } 
	 @AfterTest
    public void tearDown() throws Exception { 
	//driver.close();	 
	//driver.quit();
    
	 }
	 
	 public void login(String Username,String Password )
	 {
		 driver.get(baseUrl);
		 if (isAlertPresents()) 
		 {
			 driver.switchTo().alert().accept();
			 driver.switchTo().defaultContent();
			 
		 }    
		 	driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);  
		    driver.findElement(By.xpath("//*[@id='txtUserName']")).clear();
		    type("//*[@id='txtUserName']",Username);
		    driver.findElement(By.xpath("//*[@id='txtPassword']")).clear();
		    type("//*[@id='txtPassword']",Password);
		    click("//*[@id='btnLogin']");
		    
//			WebDriverWait wait = new WebDriverWait(driver,30);
//			wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".logotable2>tbody>tr>td")));
			
	 }
	 
	 public void Logout() throws Exception
	   {
		  
		//driver.get(baseUrl);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);  
		driver.findElement(By.xpath("//img[@alt='Exit']")).click();	
	    
	  }
	 
	 
	 public void type(String locator, String text) {
			waitFor(locator);
			WebElement element = find(locator);
			element.clear();
			element.sendKeys(text);
		}

	/*	public void click(String locator) {
			try
			{
			waitFor(locator);
			find(locator).click();
			}catch (Exception e) {
			System.out.println(e);
		}
		} */
	 public void click(String locator) {
         for (int i = 0; i < 5; i++)
         {
                         try {
                                         waitFor(locator);
                                         find(locator).click();
                                         break;
                         } catch (ElementNotInteractableException ex) { // from org.openqa.selenium.ElementNotInteractableException
                                         continue;
                         } catch (Exception e) { // Fail on all other exceptions
                                         System.out.println(e);
                                         break;
                         }
         	}
	 	}
	 
	 
	 public void JavaScriptclick(String locator) {
         for (int i = 0; i < 5; i++)
         {
                         try {
                                        waitFor(locator); 
                                        WebElement setElement = find(locator);
                                 		JavascriptExecutor js = (JavascriptExecutor) driver;
                                 		js.executeScript("arguments[0].click()", setElement);
                                         break;
                         } catch (ElementNotInteractableException ex) { // from org.openqa.selenium.ElementNotInteractableException
                                         continue;
                         } catch (Exception e) { // Fail on all other exceptions
                                         System.out.println(e);
                                         break;
                         }
         	}
	 	}

		public WebElement find(String locator) {
			By by = parseLocator(locator);
			List<WebElement> elements = driver.findElements(by);

			if (elements.size() == 0) {
				throw new AssertionError("Could not find any element matching '" + locator + "'");
				//return null;
			} else if (elements.size() > 1) {
				System.err.println("Found " + elements.size() + " elements matching '" + locator + "'");
			}
			return elements.get(0);
		}

		public By parseLocator(String locator) {
			By by;
			if (locator.startsWith("xpath=")) {
				String xpath = locator.substring("xpath=".length());
				by = By.xpath(xpath);
			} else if (locator.startsWith("//")) { //only implicit xpath supported
				by = By.xpath(locator);
			} else if (locator.startsWith("#") && locator.indexOf(" ") < 0 && locator.indexOf(".") < 0 && locator.indexOf(",") < 0) {
				by = By.id(locator.substring(1));
			} else {
				by = By.cssSelector(locator);
			}
			return by;
		}

		public boolean exists(String locator) {
			By by = parseLocator(locator);
			return driver.findElements(by).size() > 0;
		}

		public boolean isElementPresent(String locator) {
			return exists(locator);
		}

		/*public void waitFor(String locator) {
			long timeout = System.currentTimeMillis() + TIMEOUT;
			while (System.currentTimeMillis() < timeout) {
				if (isElementPresent(locator)) {
					return;
				}
				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
					throw new RuntimeException(e);
				}
			}
			throw new AssertionFailedError("Timeout during waiting for element: '" + locator + "'");
		} */
		
		 public void waitFor(String locator) {
             try {
                             new WebDriverWait(driver, (TIMEOUT / 1000), 200)
                                                             .until(ExpectedConditions.visibilityOfElementLocated(parseLocator(locator)));
             } catch (TimeoutException e) { // from org.openqa.selenium.TimeoutException 
                             throw new AssertionError("Timeout during waiting for element: '" + locator + "'");
             }
		 }
		 
		 public void waitForEnable(String locator) {
             try {
                             new WebDriverWait(driver, (TIMEOUT / 1000), 200)
                                                             .until(ExpectedConditions.elementToBeClickable(parseLocator(locator)));
             } catch (TimeoutException e) { // from org.openqa.selenium.TimeoutException 
                             throw new AssertionError("Timeout during waiting for element: '" + locator + "'");
             }
		 }
		 
		 public void waitForSelectOption(String Locator)
		 {
			 try
			 {

			  new WebDriverWait(driver, (TIMEOUT / 1000), 200).until(
					    ExpectedConditions
					        .presenceOfNestedElementsLocatedBy(parseLocator(Locator), By.tagName("option")));
			 
		 } catch (TimeoutException e) { // from org.openqa.selenium.TimeoutException 
             throw new AssertionError("Timeout during waiting for element: '" + Locator + "'");
		}
			 
		 }
		 
		 public void waitForvalue(String locator)
		 {
			 try
			 {
				 WebDriverWait wait = new WebDriverWait(driver, 60); 
				 wait.until(ExpectedConditions.presenceOfNestedElementsLocatedBy(parseLocator(locator),  By.tagName("value")));
			 }
			 catch (TimeoutException e) { // from org.openqa.selenium.TimeoutException 
	             throw new AssertionError("Timeout during waiting for element: '" + locator + "'");
			}
		 }

		public void SwitchFrame(String locator) {
			WebElement frameElement = driver.findElement(By.id(locator));
			driver.switchTo().frame(frameElement);

		}
		public void SwitchFrameName(String locator) {
			WebElement frameElement = driver.findElement(By.name(locator));
			driver.switchTo().frame(frameElement);

		}

		public void check(String locator) {
			waitFor(locator);
			WebElement element = find(locator);
			if (!element.isSelected()) {
				element.click();
			}
		}

		public void uncheck(String locator) {
			
			WebElement checkbox = find(locator);
			if (checkbox.isSelected()) {
				checkbox.click();
			}
		}

		public String getText(String locator) {
			return getText(locator, true);
		}

		public String getValue(String locator) {
			return find(locator).getAttribute("value");
		}

		public boolean isSelected(String locator) {
			WebElement element = find(locator);
			return element.isSelected();
		}
		
		
		public boolean isDisplayed(String locator) {
			WebElement element = find(locator);
			return element.isDisplayed();
		}
		
		public boolean isEnabled(String locator) {
			WebElement element = find(locator);
			return element.isEnabled();
		}
		public String readAlertMessageText() {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 if (isAlertPresents()) 
			 {
				 Alert alert = driver.switchTo().alert();
				 String message = alert.getText();
				 System.out.println(message);
				 return message;
			 }
			 else
			 {
				 return null;
			 }	 
		}
		
		public void AcceptAlert()
		{
			 driver.switchTo().alert().accept();
			 driver.switchTo().defaultContent();
		}

		public String getText(String locator, boolean onlyVisible) {
			if (onlyVisible) {
				return find(locator).getText().trim();
			} else {
				WebElement e = find(locator);
				try {
					return (String) ((JavascriptExecutor) driver).executeScript(
							"return arguments[0].innerHTML", e);
				} catch (Exception ex) {
					throw new RuntimeException("Failed to return text for " + locator + " on web element " + e, ex);
				}
			}
			
		}
			
	public String generateRandomData() {
		final String alphabet = "0123456789111213141516171819abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
		final int N = alphabet.length();
		char[] data= new char[10];
		Random r = new Random();
        for (int i = 0; i < 10; i++) {
		      data[i] =alphabet.charAt(r.nextInt(N));
		    }
        String RandomData = String.valueOf(data);
        return "QA"+RandomData;
			
		}
	
	public String generateRandomNumber() {
		final String alphabet = "0123456789";
		final int N = alphabet.length();
		char[] data= new char[10];
		Random r = new Random();
        for (int i = 0; i < 7; i++) {
		      data[i] =alphabet.charAt(r.nextInt(N));
		    }
        String RandomData = String.valueOf(data);
        //System.out.println(RandomData);	
        return RandomData;
			
		}
	public boolean isAlertPresents() {
		try {
		driver.switchTo().alert();
		return true;
		}// try
		catch (Exception e) {
		return false;
		}// catch
		}
       
	public void CheckExtraTabs()  {
		String originalHandle = driver.getWindowHandle();

	    //Do something to open new tabs

	    for(String handle : driver.getWindowHandles()) {
	        if (!handle.equals(originalHandle)) {
	            driver.switchTo().window(handle);
	            driver.close();
	        }
	    }

	    driver.switchTo().window(originalHandle);
	    
	}
	public void select(String locator, String optionLocator) {
		Select select = new Select(find(locator));
		if (optionLocator.startsWith("index=")) {
			select.selectByIndex(Integer.parseInt(optionLocator.substring("index=".length())) - 1); //selectByIndex is zero-based, out api was 1-based
		} else if (optionLocator.startsWith("value=")) {
			select.selectByValue(optionLocator.substring("value=".length()));
		} else if (optionLocator.startsWith("label=")) {
			select.selectByVisibleText(optionLocator.substring("label=".length()));
		} else {
				select.selectByVisibleText(optionLocator);
		}
	}
	
	public void Handle_windows_Popup() throws Exception 
	{
		Robot object=new Robot();

		// Press Enter
		object.keyPress(KeyEvent.VK_ENTER);

		// Release Enter
		object.keyRelease(KeyEvent.VK_ENTER);
		 
	}
	
	protected boolean isFileDownloaded(String ext) {

		 String DownloadLocation="C:\\Users\\sebastian\\Downloads";
		
		// TODO Auto-generated method stub
		boolean flag=false;
	    File dir = new File(DownloadLocation);
	    File[] files = dir.listFiles();
	    if (files == null || files.length == 0) {
	        flag = false;
	    }
	    
	    for (int i = 1; i < files.length; i++) {
	    	if(files[i].getName().contains(ext)) {
	    		flag=true;
	    	}
	    }
	    return flag;
	}
	
/*	public static FirefoxProfile firefoxProfile() throws Exception 
    {
		String downloadPath="D:\\SeleniumDownloads";

		FirefoxProfile firefoxProfile = new FirefoxProfile();
		firefoxProfile.setPreference("browser.download.folderList", 2);
		firefoxProfile.setPreference("browser.download.dir", downloadPath);
		firefoxProfile.setPreference("browser.helperApps.neverAsk.saveToDisk", "application/pdf");
		firefoxProfile.setPreference("pdfjs.disabled", true); 

		return firefoxProfile;
 }
	*/
	
	
	protected void FileDelete()
	{
	
		    File dir = new File(downloadPath);
		    File[] files = dir.listFiles();
		    for (int i = 0; i < files.length; i++) {
		    	
		    	if (files == null || files.length == 0) {
			        break;
			    }
		    	else
		    	{
		    		files[i].delete();
		    	}
		    }
		  
	}
	
	protected boolean isFileDownloaded_Ext(String dirPath, String ext){
		boolean flag=false;
	    File dir = new File(dirPath);
	    File[] files = dir.listFiles();
	    if (files == null || files.length == 0) {
	        flag = false;
	    }
	    
	    for (int i = 0; i < files.length; i++) {
	    	if(files[i].getName().contains(ext)) {
	    		flag=true;
	    	}
	    }
	    return flag;
	}
	
	//To scroll Down to the end of the page
	public void Scroll_DowntoEnd()
	{
		((JavascriptExecutor) driver)
	     .executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}
	//To scroll to a specific location.
	public void ScrollTo_Location(String locator)
	{
		WebElement element = find(locator);
		((JavascriptExecutor) driver).executeScript(
		"arguments[0].scrollIntoView();", element);
	}
	
	//*****************************************Test Listner *********************************	
	

}
