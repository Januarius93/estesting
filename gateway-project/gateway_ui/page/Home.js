import { StyleSheet, Text, View } from "react-native";

import LinkComponent from "../component/LinkComponent";
const Home = () => {
  return (
    <View style={styles.homeStyle}>
      <Text>This is main Esteting page</Text>
      <Text>In construction...</Text>

      <Text>
        Click to <LinkComponent url="/signup" pageName="signup" />
      </Text>

      <Text>
        Click to <LinkComponent url="/signin" pageName="signin" />
      </Text>
    </View>
  );
};

export default Home;

const styles = StyleSheet.create({
  homeStyle: {
    flex: 1,
    backgroundColor: "#fff",
    alignItems: "center",
    justifyContent: "center",
  },
});
