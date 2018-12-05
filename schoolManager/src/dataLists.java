public class dataLists {
    public static student getDataLists() {
        student rs = new student (null, "Rodger", "Smith");
        student lw = new student (rs, "Lucy", "Weaver");
        student dw = new student (lw, "Dave", "White");
        student pp = new student (dw, "Percy", "Parker");
        student bg = new student (pp, "Beth", "Glasper");
        student ab = new student (bg, "Annie", "Blaine");
        student tt = new student (ab, "Theo", "Thorn");
        student bs = new student(tt, "Bruce", "Springer");
        student aa = new student(bs, "Alexa", "Allen");
        student jt = new student(aa, "John", "Thompson");
        student bcO = new student(jt, "Zac", "Johnson");
        student jr = new student(bcO, "Janice", "Robertson");
        student php = new student(jr, "Phill", "Piper");
        student sr = new student(php, "Steph", "Roe");
        student ra = new student(sr, "Ryan", "Auger");
        student sm = new student(ra, "Sam", "McManus");
        student bc = new student(sm, "Ben", "Carr");
        student el = new student (bc, "Eva", "Little");
        student ls = new student (el, "Luke", "Skywalker");
        student gj = new student (ls, "Gavin", "Jenkins");
        student fp = new student (gj, "Franky", "Potter");
        student gb = new student (fp, "Gerrie", "Bennett");
        student df = new student (gb, "Daisy", "Flowers");
        student rl = new student (df, "Robert", "Lynn");


        rs.setPrevious(lw);
        lw.setPrevious(dw);
        dw.setPrevious(pp);
        pp.setPrevious(bg);
        bg.setPrevious(ab);
        ab.setPrevious(tt);
        tt.setPrevious(bs);
        bs.setPrevious(aa);
        aa.setPrevious(jt);
        jt.setPrevious(bcO);
        bcO.setPrevious(jr);
        jr.setPrevious(php);
        php.setPrevious(sr);
        sr.setPrevious(ra);
        ra.setPrevious(sm);
        sm.setPrevious(bc);
        bc.setPrevious(el);
        el.setPrevious(ls);
        ls.setPrevious(gj);
        gj.setPrevious(fp);
        fp.setPrevious(gb);
        gb.setPrevious(df);
        df.setPrevious(rl);
        rl.setPrevious(null);
        return rl;
    }
}
