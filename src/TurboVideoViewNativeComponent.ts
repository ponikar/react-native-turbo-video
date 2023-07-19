import codegenNativeComponent from 'react-native/Libraries/Utilities/codegenNativeComponent';
import type { ViewProps } from 'react-native';

interface NativeProps extends ViewProps {
  uri?: string;

  width?: number;
  height?: number;

  currentDuration?: number;
}

export default codegenNativeComponent<NativeProps>('TurboVideoView');
