import * as React from 'react';

import { StyleSheet, View } from 'react-native';
import { TurboVideoView } from 'react-native-turbo-video';

export default function App() {
  return (
    <View style={styles.container}>
      <TurboVideoView
        uri="https://www.pexels.com/download/video/5057528/?fps=25.0&h=1440&w=2560"
        style={styles.box}
      />
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    alignItems: 'center',
    justifyContent: 'center',
    borderWidth: 1,
    borderColor: '#000',
  },
  box: {
    width: "100%",
    height: "500",
   flex: 1,
  },
});
