package com.estesting.gateway.data;

import com.estesting.gateway.form.SignInForm;

public class SignInFormTestData {

  public static SignInForm buildValidSignInForm() {
    return SignInForm.builder().login("Josh567890").password("some567890").build();
  }

  public static SignInForm buildEmptyLoginSignInForm() {
    return SignInForm.builder().login("").password("somepwd").build();
  }

  public static SignInForm buildNullLoginSignInForm() {
    return SignInForm.builder().login(null).password("somepwd").build();
  }

  public static SignInForm buildEmptyPasswordSignInForm() {
    return SignInForm.builder().login("somelogin").password("").build();
  }

  public static SignInForm buildNullPasswordSignInForm() {
    return SignInForm.builder().login("somelogin").password(null).build();
  }

  public static SignInForm buildAllEmptyFieldsSignInForm() {
    return SignInForm.builder().login("").password("").build();
  }

  public static SignInForm buildAllNullFieldsSignInForm() {
    return SignInForm.builder().login(null).password(null).build();
  }

  public static SignInForm buildNoDataFieldsSignInForm() {
    return SignInForm.builder().build();
  }

  public static SignInForm buildTooShortFieldsSignInForm() {
    return SignInForm.builder().login("fogprospf").password("ofproldow").build();
  }

  public static SignInForm buildTooLongFieldsSignInForm() {
    return SignInForm.builder()
        .login(
            "pcpdqiqwkdzvxuvlaiurlwodysskyweznqxczjucyjxzpgqtaix\n"
                + "zgccllkitapgknujfpkijhgvkjrkhkjpvoefivpvgoztkxxuxke\n"
                + "nihywrklocubigvoidniczwzkcxbelnwdehytzujmflwfjccxsh\n"
                + "agfwvmxbecvhjvrzlijnmorxkzbqhghbtxwfgkagijhsauyqxaj\n"
                + "pezfpohldpulgaueppxdfligucpgplwufurvgazoxtuwelbukch")
        .password(
            "mwbiuqswqwzkaakqzdwayxihjbsquemoqdrezabltnrkrngnptywpspobmhfcytycvukhihgwlhsudfweusiuicvfmodanvsjctbootivoxrrckvznowmkumkcpcmnkkpjugdqfjkpklazumblhfmamnzqlrlaovtejgfeewgswpvoogodppguqffbnogvnfscmhdnomz\n"
                + "skmzhlctbxzjrfeiwgjwvfveyyzlahlrwwhvugdbfqxlwqqkbkznamsmdunwgokzlitdwkbkijeysefjioteirplkfpymsuduthnlwhfpiwrxpoikvitjgmzyhxjastpauwhiwyfzptlqxkknmlewthhgrzliqkguvwgdmvuhzkzwhparpjesaurcgdpouumqtbljzzeg\n"
                + "evfdcdtgmbzdzgyhcriipopucrfgupiojljfuhvurgpabuycbxnkclvhyaopdqrzneqeskzpjmhfviivwuqhecfsvgvchfpkacoelmlkxafzpwyttxxzlblfepzlyfevqqatqrszzyrhmtgdfygezdwowikiqlawcmlwkkrxadmtmqwyazsftdxztvezzqprgzcqlhcby\n"
                + "fajgkilqxgmeumrrmkkeraiwkxzkltidujqqwjjfatwlhjrcsoftinbxnolwydhkiycsosemictxnmdmwtjadcfsskxqfkzshsjohpthvclptkquwuymicjdwniqatczpxztzhghtzhtzseactouzonubgcipbyvtgrpxcbgvpakbpgptkxqkirfkcdelhfesocouxocw\n"
                + "jabywkkgvoawtwzzctmrlqvxcacbdlpunouluypeegbexdrrhqyzlxhsfrechlekptyzpqhwpljfqphboidhbwkefnwwlkejmlcmahzbmzmrdejzmzqozvzooswmjqbrrbielixjxswbtjuecicivcvtdcnpgcadilgecozrrueqnwyxexndeehgijpkgktwzvbcsrvvc")
        .build();
  }
}
