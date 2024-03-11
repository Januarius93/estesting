import {
  StyleSheet,
  Text,
  Button,
  SafeAreaView,
  Alert,
  Image,
  View,
  Dimensions,
} from "react-native";

import LinkComponent from "../component/LinkComponent";
const Home = () => {
  return (
    <SafeAreaView style={styles.homeStyle}>
      <View style={styles.testView}></View>
      <Image source={require("../assets/favicon.png")}></Image>
      <Text>This is main Esteting page</Text>
      <Text>In construction...</Text>
      <Text>Click to signup</Text>
      <Button
        color={"#C9D5E1"}
        title="signup"
        onPress={() => navigation.navigate("Signup")}
      ></Button>
      <Text>Click to signin</Text>
      <Button
        backgroundColor="red"
        color={"#C9D5E1"}
        title="signin"
        onPress={() => alert("!!!")}
      ></Button>
    </SafeAreaView>
  );
};

export default Home;

const styles = StyleSheet.create({
  homeStyle: {
    flex: 1,
    backgroundColor: "#3398FF",
    alignItems: "",
    justifyContent: "center",
  },
  testView: {
    backgroundColor: "black",
    flex: 0.1,
  },
});
