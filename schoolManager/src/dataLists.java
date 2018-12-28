public class dataLists {
    public static student getDataList1() {
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

    public static student getDataList2() {
        student rs = new student (null, "Fred", "Smithson");
        student lw = new student (rs, "Dan", "Weaverson");
        student dw = new student (lw, "Tom", "Whiteson");
        student pp = new student (dw, "Sam", "Parkerson");
        student bg = new student (pp, "Ben", "Glasperson");
        student ab = new student (bg, "Ann", "Blaineson");
        student tt = new student (ab, "Rose", "Thornson");
        student bs = new student(tt, "Bruno", "Springerson");
        student aa = new student(bs, "Alex", "Allenson");
        student jt = new student(aa, "Joan", "Thompsonson");
        student bcO = new student(jt, "Mo", "Johnson");
        student jr = new student(bcO, "Jen", "Robertson");
        student php = new student(jr, "Phebe", "Piperson");
        student sr = new student(php, "Stan", "Roeson");
        student ra = new student(sr, "Reo", "Augerson");
        student sm = new student(ra, "Sonnie", "McManusson");
        student bc = new student(sm, "Bettie", "Carrson");
        student el = new student (bc, "Evan", "Littleson");
        student ls = new student (el, "Lottie", "Skywalkerson");
        student gj = new student (ls, "Genia", "Jenkinsson");
        student fp = new student (gj, "Frank", "Potterson");
        student gb = new student (fp, "Gert", "Bennettson");
        student df = new student (gb, "Donnie", "Flowerson");
        student rl = new student (df, "Rosie", "Lynnson");


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
