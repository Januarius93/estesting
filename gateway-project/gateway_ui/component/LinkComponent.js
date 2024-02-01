import React from "react";
import { Pressable, Text, Linking } from "react-native";

const LinkComponent = ({ url, pageName }) => {
  const handlePress = () => {
    if (url) {
      Linking.openURL(url);
    }
  };

  return (
    <Pressable onPress={handlePress}>
      <Text style={{ color: "blue" }}>{pageName}</Text>
    </Pressable>
  );
};

export default LinkComponent;
