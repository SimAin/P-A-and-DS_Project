public class mediaList {
    public static album getMediaList() {
        album metSt = new album (null, "Metallica", "St Anger");
        album metSo = new album (metSt, "Metallica", "Some Kind Of Monster");
        album metD = new album (metSo, "Metallica", "Death Magnetic");
        album metH = new album (metD, "Metallica", "Hardwired");
        album acFor = new album (metH, "AC/DC", "For Those About to Rock (We Salute You)");
        album acH = new album (acFor, "AC/DC", "Highway to Hell");
        album actR = new album (acH, "AC/DC", "The Razors Edge");
        album bsB = new album(actR, "Bruce Springsteen", "Born In The U.S.A");
        album bsR = new album(bsB, "Bruce Springsteen", "The River");
        album bsBr = new album(bsR, "Bruce Springsteen", "Born To Run");
        album bcO = new album(bsBr, "Biffy Clyro", "Only Revolutions");
        album runTo = new album(bcO, "Run-D.M.C", "Tougher Than Leather");
        album pcNo = new album(runTo, "Phill Collins", "No Jacket Required");
        album bsSs = new album(pcNo, "Band of Skulls", "Sweet Sour");
        album sbt = new album(bsSs, "Sleigh Bells", "Treats");
        album pPr = new album(sbt, "Prince", "Purple Rain");
        album dbSm = new album(pPr, "David Bowie", "Scary Monsters");
        album imNum = new album (dbSm, "Iron Maiden", "The Number Of The Beast");
        album imSo = new album (imNum, "Iron Maiden", "Somewhere In Time");
        album glAM = new album (imSo, "The Gaslight Anthem", "American Slang");
        album ftEn = new album (glAM, "Frank Turner", "England keep my bones");
        album ftPs = new album (ftEn, "Frank Turner", "Positive Songs for Negative People");
        album gdAm = new album (ftPs, "Green Day", "American Idiot");
        album amWc = new album (gdAm, "Against Me", "White Crosses / Black Crosses");


        metSt.setPrevious(metSo);
        metSo.setPrevious(metD);
        metD.setPrevious(metH);
        metH.setPrevious(acFor);
        acFor.setPrevious(acH);
        acH.setPrevious(actR);
        actR.setPrevious(bsB);
        bsB.setPrevious(bsR);
        bsR.setPrevious(bsBr);
        bsBr.setPrevious(bcO);
        bcO.setPrevious(runTo);
        runTo.setPrevious(pcNo);
        pcNo.setPrevious(bsSs);
        bsSs.setPrevious(sbt);
        sbt.setPrevious(pPr);
        pPr.setPrevious(dbSm);
        dbSm.setPrevious(imNum);
        imNum.setPrevious(imSo);
        imSo.setPrevious(glAM);
        glAM.setPrevious(ftEn);
        ftEn.setPrevious(ftPs);
        ftPs.setPrevious(gdAm);
        gdAm.setPrevious(amWc);
        amWc.setPrevious(null);
        return amWc;
    }
}
