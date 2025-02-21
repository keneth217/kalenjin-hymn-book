package com.keneth.hymnbook

object HymnRepository {
    private val hymns = mutableListOf<Hymn>()

    init {
        hymns.add(
            Hymn(
                number = 1, title = "Kilosu Jehovah nguno", isFavourite = true, stanzas = listOf(
                    "Kilosu Jehovah nguno\n" + "Ne konech kaberurennyi.\n" + "Kilosu Kwanda ak Jesu,\n" + "Ak Tamirmiriet ne Tilil. "
                ), chorus = ""
            )
        )

        hymns.add(
            Hymn(
                number = 2, title = "Kilosu Kwandanyo", isFavourite = true, stanzas = listOf(
                    "Kilosu Kwandanyo,\n" + "Werit ak Tamirmiriet ne Tilil\n" + "Kit ne ki u eng' ta-u-net,\n" + "Nguno ak eng' che bwanei,\n" + "Agoi koigeny! Amen, Amen!"
                ), chorus = ""
            )
        )

        hymns.add(
            Hymn(
                number = 3,
                title = "Otienjin Kiptaiyandenyon",
                isFavourite = false,
                stanzas = listOf(
                    "Otienji Kiptaiyandennyo,\n" + "Okwek tugul che omi ng'ony;\n" + "Olosu Ine kotugul;\n" + "Obwanji si ogasge kot.",
                    "Kamukta-indet Jehovah,\n" + "Kiyaech Ine Inegei.\n" + "Mestowondennyo Inendet;\n" + "Ba-ech amu ki akwennyi.",
                    "Obwa olosu Jehovah,\n" + "Orikyi oboibo-itu;\n" + "Olosu Inendet agoi,\n" + "Amu kararan kainennyi.",
                    "Toror Kiptaiyat Jehovah,\n" + "Mabegu chamnyennyi ne o.\n" + "Kimen ng'alekyik kotugul,\n" + "Ma walaksei; tebyei koigeny. "
                ),
                chorus = ""
            )
        )

        hymns.add(
            Hymn(
                number = 4, title = "Kilosun Jehovah Mising", isFavourite = false, stanzas = listOf(
                    "Kilosun, Jehovah, mising':\n" + "Kilosu Wering'ung',\n" + "Kiptaiyandet ne Yetindet\n" + "Ne bo ng'oony komugul.\n" + "Kiptaiyandet ne Yetindet\n" + "Ne bo ng'ony ko-mugul.",
                    "Kongoi mising' kot. Jehovah,\n" + "Kilosun, Kwandanyo,\n" + "Amu ki'yokwech We-ring'ung'\n" + "Komechi bik tugul.\n" + "Amu ki'yokwech We-ring'ung',\n" + "Komechi bik tugul.",
                    "Kongoi Jesu Kristo,\n" + "Weritab Jehovah;\n" + "I Choruennyo ne cha-mech kot;\n" + "1 Kosobindennyo.\n" + "1 Choruennyo ne cha-mech kot;\n" + "I Kosobi-ndennyo.\n",
                    "4. Kilosun. Jehovah. mising'.\n" + "Kilosu Wering'ung'.\n" + "Ak Tamirmiriet ne Tilil.\n" + "Kagaiga-indennyo.\n" + "Ak Tamirmiriet ne Tilil.\n" + "Kagaiga-i-ndennyo. "
                ), chorus = ""
            )
        )

        hymns.add(
            Hymn(
                number = 5, title = "Kigaktoin Kiptaiyandet", isFavourite = false, stanzas = listOf(
                    "Kigakto-in, Kiptaiyandet, \n" + "Eng' betusiek tugul; Kimang'un, \n" + "Inye, kotugul, Koboch eng' tai, agoi. ",
                    "Ki ribotin, achek, biguk \n" + "Eng' eung'ung' ne kim; \n" + "Matwa-ech kiy ye inamech, \n" + "Kamukta-indennyo. ",
                    "Ye kingotom iyai ng'onyut, \n" + "Emet ak tulonok, \n" + "Ko ki-imite koboch keny, \n" + "Ak imite koigeny. ",
                    "U betunak eng' Jehovah \n" + "Kenyisiekyok tugul. \n" + "Chokta betusiekyok \n" + "eng ng'ony Isib kogesugei.",
                    "'Netech ki-it betusiekyok \n" + "Asi mabetyo buch; \n" + "Konech keboisie-un komie \n" + "Kota kemite ng'ony. \n",
                    "Jehovah, ki-itoretech \n" + "Eng' kenyisiek tugul, \n" + "Ak iribotech kotugul \n" + "Kot keit oldang'ung'.  "
                ), chorus = ""
            )
        )

        hymns.add(
            Hymn(
                number = 6, title = "Lumeiywotab kaniset", isFavourite = false,

                stanzas = listOf(
                    "Lumeiywotab kaniset\n" + "Ko Jesu Kiptaiyat\n" + "Achek ko ki teeksennyi\n" + "Ne menyei Inendet.\n" + "Kicham Ine kocheng'ech\n" + "Ye kigi betyotin\n" + "Kot konyo ng'ony komechech \n" + "Kosoruech eng' luset",
                    "Kergei kayanik tugul \n" + "Eng' ng'onyut komugul; \n" + "Agenge sigunenywa, \n" + "Agenge kayanet;\n" + "Agenge amitwogik \n" + "Che bo sobonwekwak;\n" + "Bo or agenge tugul\n" + "Agenge eng' Jesu.",
                    ".Eng’ usisiet ak boisiet \n" + "Ak lugosiek che chang\n" + "Koripsei kanisenyin\n" + "Kot koweek kiptaiyat.\n" + "Kimuung’jin tun kayanik\n" + "Eng' yomsosiek tugul\n" + "Amun katerterindet\n" + "Ko laitoriandenywa \n"
                ), chorus = ""
            )
        )

        hymns.add(
            Hymn(
                number = 7, title = "Tilil! Tilil! Tilil!",
                isFavourite = false, stanzas = listOf(
                    "Tilil! TiliI! Tilil! Jehovah Kiptaiyat!\n" +
                            "Inendet ko TiIiI - mami ne kiroge.\n" +
                            "Kwanda ak ko Werit, ak ko Tamirmiriet,\n" +
                            "2. Toror kot Inendet - otei bikab iman;\n" +
                            "Ak ma1aika-isiek, kolosu agichek.\n" +
                            "Kimitei koboch keny, ak komitei nguno;\n" +
                            "Ak mitei koi'geny - Ine Kwandanyo.",
                    "TiIiI kot Jehovah! Matinyei mesundei.\n" +
                            "Mageerei Inendet bik che bo tengekto.\n" +
                            "Bo-unindet Ine, ak Kamukta-indet.\n" +
                            "Nenyi kimnatet. ak torornatet,.",
                    "Tilil! Tilil! Tilil! I toror Inyege\n" +
                            "I Ya-indet, 1nye, ne bo tuguk tugul.\n" +
                            "Nguno, karonani. ketieni kilosun\n" +
                            "Inye, Jehovah, Kamukta-indet. "
                ), chorus = ""
            )
        )

        hymns.add(
            Hymn(
                number = 8, title = "Tun nyone Jesu ngwony kogeny",
                isFavourite = false, stanzas = listOf(
                    "Tun nyonei Jesu ng'ony kogeny\n" +
                            "Nyo kolaitorane tugul;\n" +
                            "Si kong'any bik tu-gul inne\n" +
                            "Kole Kiptaiyat Inendet.", "2. Osoru bik che lusyotin\n" +
                            "Kobwanji Laitoriandennyo.\n" +
                            "Kasei kabe-ru-ret ne o\n" +
                            "Bik che kisoru eng' me-et.",
                    "'Ngotesak laitornatennyi\n" +
                            "Eng' mugulelwekyok tugul.\n" +
                            "Ongemwaitaa-te ng'a-lechu\n" +
                            "Kogas emotinwek tugul.\n",
                    "Kisa-e Jesu kotugul\n" +
                            "Ak kitorori Kainennyi.\n" +
                            "Nyoljin Ine-ndet tee-gisto\n" +
                            "Ine ne o kosiir tugul.",
                    "5. Obwa ketien eng' karemet,\n" +
                            "Kiborjin bik katiaknatet:\n" +
                            "Si koyom bik tugul eng' ng'ony\n" +
                            "Kalosunetab Kiptaiyat."
                ), chorus = ""
            )
        )

        hymns.add(
            Hymn(
                number = 9, title = "Jehovah Irimet ne kim",
                isFavourite = false,
                stanzas = listOf(
                    "Jehovah irimet ne kim\n" +
                            "Ne mwechin bik the 'yanotin;\n" +
                            "Ne toretech eng' maranet\n" +
                            "Ye kinyalildosi mising'.\n" +
                            "Amu cheng'ei bunyot\n" +
                            "Oret ne ng'emenech;\n" +
                            "0 kot ng'omnatennyi,\n" +
                            "Karikyik ko wechet;\n" +
                            "Ki ng'alindet koboch eng' tai.",
                    " Ngot kimang'u kimnatennyo.\n" +
                            "Koek anyun buch boriennyo;\n" +
                            "Ago mi kobotech Ne Kim\n" +
                            "Ne kigoyokwech Jehovah.\n" +
                            "ilen ng'o Inendet:\n" +
                            "Kristo Jesu Ine.\n" +
                            "lnendet lnegei\n" +
                            "Ne bo-u lugosiek.\n" +
                            "Mami age ne 'terterwech.",
                    "3. Agot ngo nyiitat ng'onyuni\n" +
                            "Kimnatosiekab Setani,\n" +
                            "Ko magiywei am u kicham\n" +
                            "Kiptaiyandet koterterwech.\n" +
                            "Magitoptobeni\n" +
                            "Eng' bunyot o-indet;\n" +
                            "Ma kiy neregekyik.\n" +
                            "Amu wendi me-et.\n" +
                            "Iterterisie' Imanit."
                ), chorus = ""
            )
        )

        hymns.add(
            Hymn(
                number = 10,
                title = "Nyo inye Kaberurindet", isFavourite = false,
                stanzas = listOf(
                    "Nyo, lnye, Kaberurindet\n" +
                            "Atieni mie-mdang'ung'.\n" +
                            "Alosun amu chamnyeng'ung'\n" +
                            "Ne irirege biguk.\n" +
                            "     'Neta tiendab boibo-indang'ung'\n" +
                            "     Ne tieni che mi barak.\n" +
                            "     Alosun, Jesu. Ruandennyu;\n" +
                            "     I chamnyetab Jehovah.",
                    " Ki-iyeta eng' chamnyeng'ung'\n" +
                            "Ribota kimnateng'ung'\n" +
                            "Angen ale imutata\n" +
                            "Agoi ait oldang'ung'.\n" +
                            "     Kiabetoti eng' orennyu,\n" +
                            "     Ko a lusat eng' chalwok.\n" +
                            "     Ki-isorua eng' me-eng'ung':\n" +
                            "     Asubun inye. nguno.",
                    "O mie-indo ne kiyeta\n" +
                            "Ak koriba kochulyo.\n" +
                            "Kagonin muguleldanyu\n" +
                            "Inet koyai mageng'ung'.\n" +
                            "     I-ngonama eung'ung' ne kim\n" +
                            "     Ak kondoiywa eng' oret\n" +
                            "     Kot ait barak kipsengwet\n" +
                            "     Ak kegeerge ak inye.",

                    ), chorus = ""
            )
        )
        hymns.add(
            Hymn(
                number = 11, title = "Betutab boiboiyet",
                isFavourite = false,
                stanzas = listOf(
                    "Betutab boiboiyet ra,\n" +
                            "Betutab Jehovah;\n" +
                            "Mayae' chi ra boisiennyi,\n" +
                            "Kiote Jehovah.\n" +
                            "Kimuunyi rani kityo,\n" +
                            "Kilosu Kiptaiyat.\n" +
                            "Kiborjin bik Sirutik\n" +
                            "Ng'alekab Jehovah.",
                    "Betutab lapkeiyet ra\n" +
                            "Ne bo Kiptaiyandet;\n" +
                            "Kigase betunito\n" +
                            "Ng'alekab Jehovah.\n" +
                            "Kiba-e sobonwekyok\n" +
                            "Makatiatab sobon,\n" +
                            "Asi kegimegitu\n" +
                            "Eng' sobennyo",
                    "Kiting'ege yamda-et\n" +
                            "Ak bikab Jehovah.\n" +
                            "Kibwane si kilosu\n" +
                            "Kamukta-indennyo.\n" +
                            "Kilosu Kwanda rani\n" +
                            "Ak Werinnyi Jesu,\n" +
                            "Koboto Tamirmiriet.\n" +
                            "Ee, kilosu tugul. \n"
                ), chorus = ""
            )
        )
        hymns.add(
            Hymn(
                number = 12,

                title = "Kilosun eng' gongung'", isFavourite = false, stanzas = listOf(
                    "Kichamin, Jehovah;\n" + "Kilosun eng' gong'ung'.\n" + "Kichame kegas ng'aleguk\n" + "Che 'ndochin kelyekyok.\n",
                    "Nyolu mising' saet;\n" + "Mami ne kiroge,\n" + "Amu kituchini yoto\n" + "Kererwekyok bo met.",
                    "Kichame kot mising'\n" + "Ng'olyotab sobondo\n" + "Ne ibu boiboiyet ne o\n" + "Ak kalyet agine.",
                    "Kichame kot ketien\n" + "Kilosu Kiptaiyat\n" + "Ne rireneigei mising' kot\n" + "Agoi kebe barak.",
                    "igiilech, Kiptaiyat,\n" + "Kechamin kot kosiir;\n" + "Agoi tun kegeerin kimni\n" + "Kilosun eng' gong'ung'."
                ), chorus = "Chorus: Yeiyo ne mi kamukta"
            )
        )
        hymns.add(
            Hymn(
                number = 13, title = "Lelachen rirenosieguk.", isFavourite = true, stanzas = listOf(
                    "Lelachen rirenosieguk\n" + "Eng' karonet age tugul.\n" + "Im-uung'wech kemoi komugul-,\n" + "Konech, Jesu, kimnateng'ung'.",
                    "Igilech eng' sa-utikyok\n" + "Ak somanetab ng'aleguk.\n" + "Asi kenyoru borotet\n" + "Koboto kaberureng'ung'.",
                    "Kisomin, Kiptaiyandennyo,\n" + "Indoiywech betut komugul.\n" + "Konech kegasin it inne\n" + "Si keyai boisieng ung' komie.",
                    "Ye kagoratarat emet\n" + "Ak ko-it sait ne kimuung'e,\n" + "Kimwa-un kongoi, Kwandanyo,\n" + "Amu ripseng'ung' ne bo ra."
                ), chorus = ""
            )
        )


        hymns.add(
            Hymn(
                number = 135,
                title = "Choboge!", isFavourite = false,
                stanzas = listOf(
                    "Nwagen betusiekab chi;\n" + "U sogot ne toroksei;\n" + "U uruet ne labati. Choboge!\n" + "Choktoi kenyisiek inne,\n" + "Rigu kiruoget ak me-et.\n" + "Mwechin eutab Jesu. Choboge",

                    "Siirtoi Ming'inateng'ung'\n" + "Ko u taptok che restos;\n" + "Metinye sobet ne koi. Choboge!\n" + "Ye kuurin tamirmiriet\n" + "Megage, kiptengekyot,\n" + "Si tun koek buch rirek. Choboge!",
                    " Kas anyun, kiteun ra,\n" + "Kuurin Jesu Kiptaiyat.\n" + "Nam oretab kipsengwet. Choboge!\n" + "Mong'u eng' mesundeito;\n" + "Mwechi eutab Jesu,\n" + "Si kogasgei kipsengwet. Choboge!"
                ),
                chorus = "Choboge...Choboge!\n" + " Kas, ko ta koguurin Jesu - Choboge! \n" + " Ngot itebi eng' chalwok kesib kegerei kurget,\n" + " Ma kegasun tun rirek. Choboge!"
            )
        )


    }

    fun getAllHymns(): List<Hymn> = hymns
    fun getHymnByNumber(number: Int): Hymn? = hymns.find { it.number == number }
    fun getFavHymns(): List<Hymn> = hymns.filter { hymn -> hymn.isFavourite }
    fun getTotalHymns(): Int = hymns.size
    fun getTotalFavHymns(): Int = getFavHymns().size

    //get all hymns ordered by number
    fun getAllHymnsOrderedByNumber(): List<Hymn> = hymns.sortedBy { it.number }
    fun getHymnByTitle(title: String): Hymn? =
        hymns.find { it.title.contains(title, ignoreCase = true) }

    //search by title or name or number
    fun searchHymns(query: String): List<Hymn> {
        val results = mutableListOf<Hymn>()
        results.addAll(hymns.filter { hymn ->
            hymn.title.contains(query, ignoreCase = true) ||
                    hymn.number.toString().contains(query, ignoreCase = true)
        })
        return results

    }

    //add hymn to roomm database
    fun addHymn(hymn: Hymn) {
        hymns.add(hymn)
    }


}