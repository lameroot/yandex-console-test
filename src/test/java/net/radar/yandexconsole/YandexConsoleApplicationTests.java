package net.radar.yandexconsole;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class YandexConsoleApplicationTests {


    String s = "private CardPresentPaymentResponse depositPayment(CardPresentPaymentRequest paymentRequest) throws Exception {\n" +
            "        if (paymentRequest.isDelayTransactionRequest() && paymentRequest.isResubmission()) {\n" +
            "            throw new IllegalArgumentException(\"multiple modes set to CardPresentPaymentRequest\" + paymentRequest);\n" +
            "        }\n" +
            "\n" +
            "        ObjectMessage request = dialect.createObjectMessage(IBankConstant.MessageType.PAYMENT_REQUEST);\n" +
            "        addTidToHeader(request, paymentRequest.getTerminalId());\n" +
            "        if (StringUtils.isNotBlank(paymentRequest.getPan())) {\n" +
            "            request.setObjectField(2, paymentRequest.getPan());\n" +
            "        }\n" +
            "        request.setObjectField(3, IBankConstant.ProcessingCode.PURCHASE);\n" +
            "        request.setObjectField(4, paymentRequest.getAmount());\n" +
            "        request.setObjectField(7, new Date());\n" +
            "        request.setObjectField(11, parseLong(paymentRequest.getStan())); // stan\n" +
            "        if (paymentRequest.getTerminalDate() != null) {\n" +
            "            request.setObjectField(12, DATE_FORMAT.parse(paymentRequest.getTerminalDate())); // trans date\n" +
            "        } else {\n" +
            "            request.setObjectField(12, paymentRequest.getTransaction().getDate()); // trans date\n" +
            "        }\n" +
            "\n" +
            "        if (paymentRequest.getExpiry() != null)\n" +
            "            request.setObjectField(14, paymentRequest.getExpiry()); // expiry from keyboard\n" +
            "\n" +
            "        request.setObjectField(22, paymentRequest.getTag22()); // POS  entry Mode\n" +
            "        request.setObjectField(25, paymentRequest.getTag25()); // POS condition code\n" +
            "        if (!paymentRequest.isResubmission()) {\n" +
            "            if (StringUtils.isNotBlank(paymentRequest.getTrack2Data()))\n" +
            "                request.setObjectField(35, paymentRequest.getTrack2Data()); // track2data\n" +
            "        }\n" +
            "\n" +
            "\n" +
            "        request.setObjectField(41, paymentRequest.getTerminalId());\n" +
            "        request.setObjectField(42, paymentRequest.getProcessingId());\n" +
            "\n" +
            "        if (isNeedToFillField47Tag99(paymentRequest.getMerchant())) {\n" +
            "            Tagset field47 = request.createTagset(47);\n" +
            "            field47.set(99, PROPRIETARY_DATA_INDICATOR);\n" +
            "        }\n" +
            "\n" +
            "        if (paymentRequest.isDelayTransactionRequest() || paymentRequest.isResubmission()) {\n" +
            "            Tagset field48 = request.createTagset(48);\n" +
            "            field48.set(22, paymentRequest.isDelayTransactionRequest() ? \"D\" : \"S\");\n" +
            "            if (paymentRequest.isResubmission() && paymentRequest.getTrnId() != null) {\n" +
            "                field48.set(89, paymentRequest.getTrnId());\n" +
            "            }\n" +
            "        }\n" +
            "\n" +
            "        request.setObjectField(49, parseInt(paymentRequest.getCurrency()));\n" +
            "\n" +
            "        if (!paymentRequest.isResubmission()) {\n" +
            "            if (StringUtils.isNotBlank(paymentRequest.getPinBlock()))\n" +
            "                request.setObjectField(52, paymentRequest.getPinBlock());\n" +
            "            if (StringUtils.isNotBlank(paymentRequest.getEmvData()))\n" +
            "                request.setObjectField(55, paymentRequest.getEmvData());\n" +
            "        }\n" +
            "\n" +
            "        ObjectMessage response = facadeUtils.sendAndLog(client, request, logger);\n" +
            "\n" +
            "        CardPresentPaymentResponse paymentResult = new CardPresentPaymentResponse();\n" +
            "        setStan(paymentRequest, paymentResult);\n" +
            "        parseResponseIfCorrect(response, paymentResult);\n" +
            "\n" +
            "        return paymentResult;\n" +
            "    }";
    @Test
    void contextLoads() {
    }

}
