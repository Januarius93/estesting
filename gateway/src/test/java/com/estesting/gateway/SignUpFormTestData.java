package com.estesting.gateway;

import com.estesting.gateway.form.SignUpForm;

public class SignUpFormTestData {

  public static SignUpForm buildValidSignUpForm() {
    return SignUpForm.builder()
        .email("somepropermail@mail.com")
        .username("someusername")
        .password("someusernamepwd")
        .age(18)
        .build();
  }

  public static SignUpForm buildInvalidEmailFormatSignUpForm() {
    return SignUpForm.builder()
        .email("a.")
        .username("someusername")
        .password("someusernamepwd")
        .age(21)
        .build();
  }

  public static SignUpForm buildEmptyEmailSignUpForm() {
    return SignUpForm.builder()
        .email("")
        .username("someusername")
        .password("someusernamepwd")
        .age(18)
        .build();
  }

  public static SignUpForm buildEmptyUserNameSignUpForm() {
    return SignUpForm.builder()
        .email("somepropermail@mail.com")
        .username("")
        .password("somepwdsomepwd")
        .age(18)
        .build();
  }

  public static SignUpForm buildEmptyPasswordSignUpForm() {
    return SignUpForm.builder()
        .email("somepropermail@mail.com")
        .username("someusername")
        .password("")
        .age(18)
        .build();
  }

  public static SignUpForm buildAgeBelow18SignUpForm() {
    return SignUpForm.builder()
        .email("somepropermail@mail.com")
        .username("someusername")
        .password("someusernamepwd")
        .age(17)
        .build();
  }

  public static SignUpForm buildAgeAbove100SignUpForm() {
    return SignUpForm.builder()
        .email("somepropermail@mail.com")
        .username("someusername")
        .password("someusernamepwd")
        .age(101)
        .build();
  }

  public static SignUpForm buildAllEmptyFieldsSignUpForm() {
    return SignUpForm.builder().email("").username("").password("").age(101).build();
  }

  public static SignUpForm buildAllNullFieldsSignUpForm() {
    return SignUpForm.builder().email(null).username(null).password(null).age(null).build();
  }

  public static SignUpForm buildNoDataSignUpForm() {
    return SignUpForm.builder().build();
  }

  public static SignUpForm buildAllFieldsSmallerInvalidSizeDataSignUpForm() {
    return SignUpForm.builder()
        .email("a@")
        .username("dowp4odpl")
        .password("dowlfospl")
        .age(17)
        .build();
  }

  public static SignUpForm buildAllFieldsGreaterInvalidSizeDataSignUpForm() {
    return SignUpForm.builder()
        .email(
            "somepropermailsomepropermailsomepropermailsomepropermailsomepropermailsomepropermailsomepropermailsomepropermailsomepropermailsomepropermailsomepropermailsomepropermailsomepropermailsomepropermail@mail.com")
        .username(
            "    \"pcpdqiqwkdzvxuvlaiurlwodysskyweznqxczjucyjxzpgqtaix\\n\"\n"
                + "                + \"zgccllkitapgknujfpkijhgvkjrkhkjpvoefivpvgoztkxxuxke\\n\"\n"
                + "                + \"nihywrklocubigvoidniczwzkcxbelnwdehytzujmflwfjccxsh\\n\"\n"
                + "                + \"agfwvmxbecvhjvrzlijnmorxkzbqhghbtxwfgkagijhsauyqxaj\\n\"\n"
                + "                + \"pezfpohldpulgaueppxdfligucpgplwufurvgazoxtuwelbukch\"")
        .password(
            " \"mwbiuqswqwzkaakqzdwayxihjbsquemoqdrezabltnrkrngnptywpspobmhfcytycvukhihgwlhsudfweusiuicvfmodanvsjctbootivoxrrckvznowmkumkcpcmnkkpjugdqfjkpklazumblhfmamnzqlrlaovtejgfeewgswpvoogodppguqffbnogvnfscmhdnomz\\n\"\n"
                + "                + \"skmzhlctbxzjrfeiwgjwvfveyyzlahlrwwhvugdbfqxlwqqkbkznamsmdunwgokzlitdwkbkijeysefjioteirplkfpymsuduthnlwhfpiwrxpoikvitjgmzyhxjastpauwhiwyfzptlqxkknmlewthhgrzliqkguvwgdmvuhzkzwhparpjesaurcgdpouumqtbljzzeg\\n\"\n"
                + "                + \"evfdcdtgmbzdzgyhcriipopucrfgupiojljfuhvurgpabuycbxnkclvhyaopdqrzneqeskzpjmhfviivwuqhecfsvgvchfpkacoelmlkxafzpwyttxxzlblfepzlyfevqqatqrszzyrhmtgdfygezdwowikiqlawcmlwkkrxadmtmqwyazsftdxztvezzqprgzcqlhcby\\n\"\n"
                + "                + \"fajgkilqxgmeumrrmkkeraiwkxzkltidujqqwjjfatwlhjrcsoftinbxnolwydhkiycsosemictxnmdmwtjadcfsskxqfkzshsjohpthvclptkquwuymicjdwniqatczpxztzhghtzhtzseactouzonubgcipbyvtgrpxcbgvpakbpgptkxqkirfkcdelhfesocouxocw\\n\"\n"
                + "                + \"jabywkkgvoawtwzzctmrlqvxcacbdlpunouluypeegbexdrrhqyzlxhsfrechlekptyzpqhwpljfqphboidhbwkefnwwlkejmlcmahzbmzmrdejzmzqozvzooswmjqbrrbielixjxswbtjuecicivcvtdcnpgcadilgecozrrueqnwyxexndeehgijpkgktwzvbcsrvvc\"")
        .age(101)
        .build();
  }
}
